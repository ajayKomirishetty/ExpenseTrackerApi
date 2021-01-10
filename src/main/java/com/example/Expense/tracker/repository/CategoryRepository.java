package com.example.Expense.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Expense.tracker.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	Category findByName(String name);
}
