package com.marques.projecttodo.services;

import com.marques.projecttodo.domain.Todo;
import com.marques.projecttodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TodoRepository todoRepository;

    public void instanciaBaseDeDados() throws ParseException {

        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular 11", LocalDate.parse("25/03/2022"), false);
        Todo t2 = new Todo(null, "Treinar", "Treinar Skil PB", LocalDate.parse("02/11/2021", formatter), true);
        todoRepository.saveAll(Arrays.asList(t1, t2));
    }
}
