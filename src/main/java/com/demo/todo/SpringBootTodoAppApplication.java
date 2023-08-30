package com.demo.todo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.todo.domain.Todo;
import com.demo.todo.repository.TodoRepository;

@SpringBootApplication
public class SpringBootTodoAppApplication implements CommandLineRunner {
	@Autowired
	public TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTodoAppApplication.class, args);
	}

	public void run(String... args) throws Exception {
//		List<Todo> todos = Arrays.asList(new Todo("Learn Spring", "Not Done", "01"), new Todo("Learn Driving", "No"),
//				new Todo("Go for a Walk", "No"), new Todo("Cook Dinner", "Yes"));
//		todos.forEach(todoRepository::save);

	}
}
