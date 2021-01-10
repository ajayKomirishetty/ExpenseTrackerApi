package com.example.Expense.tracker.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="category")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Category {
	
	@Id
	private long id;
	
	private String name;
	
}
