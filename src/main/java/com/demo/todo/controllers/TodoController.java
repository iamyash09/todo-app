package com.demo.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.todo.domain.Todo;
import com.demo.todo.repository.TodoRepository;

@Controller
public class TodoController {
	@Autowired
	TodoRepository todoRepository;

	@GetMapping
	public String index() {
		return "index.html";
	}

	@GetMapping("/todos")
	public String todos(Model model) {
		model.addAttribute("todos", todoRepository.findAll() );
		return "todos";
	}
	
	@GetMapping("/todos/{status}")
	public String todosWithStatus(@PathVariable String status, Model model) {
		model.addAttribute("todos", todoRepository.findByStatus(status));
		return "todos";
	}

	@PostMapping("/todoNew")
	public String add(@RequestParam String todoItem, @RequestParam String status, @RequestParam String dueDateTime,
			Model model) {
		Todo todo = new Todo();
		todo.setTodoItem(todoItem);
		todo.setStatus(status);
		todo.setCreated_at(todo.getCurrentDateTime());
		todo.setUpdated_at(todo.getCurrentDateTime());
		todo.setDueDateTime(dueDateTime);
		todoRepository.save(todo);
		model.addAttribute("todos", todoRepository.findAll());
		return "redirect:/todos";
	}
	
	@PostMapping("/todoUpdate/{id}")
	public String todoupdate(@PathVariable long id, @RequestParam String todoItem, @RequestParam String status, @RequestParam String dueDateTime,
			Model model) {
		Todo todo = todoRepository.findById(id).get();
		todo.setTodoItem(todoItem);
		todo.setStatus(status);
		todo.setUpdated_at(todo.getCurrentDateTime());
		todo.setDueDateTime(dueDateTime);
		todoRepository.save(todo);
		model.addAttribute("todos", todoRepository.findAll());
		return "redirect:/todos";
	}
	
	@PostMapping("/todoDelete/{id}")
	public String delete(@PathVariable long id, Model model) {
		todoRepository.deleteById(id);
		model.addAttribute("todos", todoRepository.findAll());
		return "redirect:/todos";
	}

	@PostMapping("/todoUpdateStatus/{id}/{status}")
	public String update(@PathVariable long id, @PathVariable String status, Model model) {
		Todo todo = todoRepository.findById(id).get();
		todo.setStatus(status);
		todoRepository.save(todo);
		model.addAttribute("todos", todoRepository.findAll());
		return "redirect:/todos";
	}
}