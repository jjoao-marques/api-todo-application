package com.marques.projecttodo;

import com.marques.projecttodo.domain.Todo;
import com.marques.projecttodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.ColumnMapRowMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class ProjectTodoApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(ProjectTodoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


    }
}
