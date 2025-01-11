package com.isaiah.personalexpensesproject.repositories;

import com.isaiah.personalexpensesproject.objects.Expense;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	
	//Save or update Expense
	<S extends Expense> S save (S Expense);
	
	//Read operations
	Optional<Expense> findByexpenseid(long id);
	List<Expense> findByuserid(long id);
	
	//delete operations
	void deleteByexpenseid(long id);
	void delete(Expense expense);
	void deleteByExpenseidIn(List<Long> expenseids);
	
	
}
