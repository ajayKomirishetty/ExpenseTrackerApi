package com.example.Expense.tracker.controller;

import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;
import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Expense.tracker.model.Expense;
import com.example.Expense.tracker.repository.ExpenseRepository;

@RestController
@RequestMapping("/api")
public class ExpenseController {

	private ExpenseRepository expenseRepository;
	
	public ExpenseController(ExpenseRepository expenseRepository) {
		super();
		this.expenseRepository = expenseRepository;
	}
	
	
	@GetMapping("/expenses")
	Collection<Expense> expenses(){
		return expenseRepository.findAll();
	}
	
	@GetMapping("/expense/{id}")
	ResponseEntity<?>	getExpense(@PathVariable Long id){
		Optional<Expense> expense=  expenseRepository.findById(id);
		return expense.map(response -> ResponseEntity.ok().body(expense)).orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/expenses")
	ResponseEntity<Expense> createExpense(@RequestBody Expense expense) throws URISyntaxException
	{
		Expense response  = expenseRepository.save(expense);
		return ResponseEntity.created(new URI("/api/category"+response.getId())).body(response);
	}
	
	@PutMapping("/expense/{id}")
	ResponseEntity<?> updateExpense(@RequestBody Expense expense)
	{
		Expense response = expenseRepository.save(expense);
		return ResponseEntity.ok().body(response);
	}
	
	@DeleteMapping("/expenses/{id}")
	ResponseEntity<?> deleteById(@PathVariable Long id){
		expenseRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
