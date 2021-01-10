package com.example.Expense.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Expense.tracker.model.Expense;


public interface ExpenseRepository extends JpaRepository<Expense, Long>{
	Expense findById(String id);

}
