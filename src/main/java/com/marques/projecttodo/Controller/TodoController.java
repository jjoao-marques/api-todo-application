package com.marques.projecttodo.Controller;

import com.marques.projecttodo.domain.Todo;
import com.marques.projecttodo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@Controller
@RequestMapping(value = "/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> findById (@PathVariable Long id) {
        Todo todo = todoService.findById(id);
        return ResponseEntity.ok().body(todo);
    }

    @GetMapping(value = "/open")
    public ResponseEntity<List<Todo>> open() {
        List<Todo> list = todoService.open();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/close")
    public ResponseEntity<List<Todo>> close() {
        List<Todo> list = todoService.close();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        List<Todo> list = todoService.findAll();
        return  ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Todo> create(@Valid @RequestBody Todo todo) {
        todo = todoService.create(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Todo> update (@PathVariable Long id, @RequestBody Todo obj) {
        Todo newObj = todoService.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }
}
