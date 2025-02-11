package com.isaiah.personalexpensesproject.services;

import com.isaiah.personalexpensesproject.objects.Expense;
import com.isaiah.personalexpensesproject.objects.ExpenseSummary;
import com.isaiah.personalexpensesproject.objects.ExpenseListing;
import com.isaiah.personalexpensesproject.objects.ExpenseSummaryRequest;
import com.isaiah.personalexpensesproject.repositories.ExpenseRepository;

import jakarta.transaction.Transactional;

import java.util.Optional;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;
	
	public Expense createExpense(Expense expense) {
		Optional<Expense> existingExpense = expenseRepository.findByexpenseid(expense.getExpenseid());
		if(existingExpense.isPresent()) {
			throw new RuntimeException("Expense with expenseid " + expense.getExpenseid() + " already exists.");
		}
		
		Expense savedExpense = expenseRepository.save(expense);
		return savedExpense;
	}
	
	public Expense readExpenseByExpenseid(long expenseid) {
		return expenseRepository.findByexpenseid(expenseid).orElse(null);
	}
	
	public List<Expense> readExpensesByUserid(long userid) {
		return expenseRepository.findByuserid(userid);
		
	}
	
	public Expense updateExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	@Transactional
	public void deleteExpenseByExpenseid(long expenseid) {
		expenseRepository.deleteById(expenseid);
	}
	
	@Transactional
	public void deleteExpensesByExpenseidIn(List<Long> expenseids) {
		expenseRepository.deleteByExpenseidIn(expenseids);
	}
	
	
	public ExpenseSummary getExpenseSummary(ExpenseSummaryRequest request) {
		//Create ExpenseSummary
		ExpenseSummary summary = new ExpenseSummary();
		
		//Get expense list
		List<ExpenseListing> expenseList = expenseRepository.generateMonthlySummary(request.getUserid(), request.getMonthCode(), request.getYear()); //Get our list of expenses and their amounts
		summary.setListings(expenseList);
		
		//Get total amount
		double totalAmount = expenseRepository.generateMonthlySummaryTotalAmount(request.getMonthCode(), request.getYear());
		summary.setTotal(totalAmount);
		
		return summary;
	}
	
	
}
