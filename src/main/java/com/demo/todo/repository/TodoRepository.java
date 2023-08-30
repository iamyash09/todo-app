package com.demo.todo.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.demo.todo.domain.Todo;
@Repository
public interface TodoRepository extends PagingAndSortingRepository<Todo,
Long>{

	
	List<Todo> findByStatus(String status);
}