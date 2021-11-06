package com.marques.projecttodo.repository;

import com.marques.projecttodo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query("SElECT td FROM com.marques.projecttodo.domain.Todo td WHERE td.finalizado = false ORDER BY td.dataParaFinalizar ASC")
    public List <Todo> findByOpen();

    @Query("SElECT td FROM com.marques.projecttodo.domain.Todo td WHERE td.finalizado = true ORDER BY td.dataParaFinalizar ASC")
    public List <Todo> findByClose();
}
