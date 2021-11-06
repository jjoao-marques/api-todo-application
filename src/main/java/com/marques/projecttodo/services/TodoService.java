package com.marques.projecttodo.services;

import com.marques.projecttodo.Messages.MessageUtil;
import com.marques.projecttodo.domain.Todo;
import com.marques.projecttodo.repository.TodoRepository;
import com.marques.projecttodo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo findById(Long id) {
       return  todoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(MessageUtil.ERROR_NOT_FOUND));
    }

    public List<Todo> open() {
         List<Todo> list = todoRepository.findByOpen();
        return list;
    }

    public List<Todo> close() {
        List<Todo> list = todoRepository.findByClose();
        return list;
    }

    public List<Todo> findAll() {
        List<Todo> list = todoRepository.findAll();
        return list;
    }

    public Todo create(Todo todo) {
        todo.setId(null);
        return todoRepository.save(todo);
    }

    public void delete(Long id) {
        findById(id);
        todoRepository.deleteById(id);
    }

    public Todo update(Long id, Todo obj) {
        Todo newObj = findById(id);
        newObj.setTitulo(obj.getTitulo());
        newObj.setDescricao(obj.getDescricao());
        newObj.setDataParaFinalizar(obj.getDataParaFinalizar());
        newObj.setFinalizado(obj.getFinalizado());

        return todoRepository.save(newObj);
    }
}
