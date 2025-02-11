package com.isaiah.personalexpensesproject.restcontrollers;

import com.isaiah.personalexpensesproject.objects.Expense;
import com.isaiah.personalexpensesproject.objects.ExpenseSummary;
import com.isaiah.personalexpensesproject.objects.ExpenseSummaryRequest;
import com.isaiah.personalexpensesproject.services.ExpenseService;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("expense")
public class ExpenseRestController {

	private final String JSON = "application/json";
	private final String LOCALHOST = "http://localhost:3000";
	
	@Autowired
	private ExpenseService expenseService;
	
	//Get Expense by Expenseid
	@GetMapping(value = "/id/{expenseid}", produces = JSON)
	@CrossOrigin(origins = LOCALHOST)
	public Expense getExpenseByExpenseid(@PathVariable long expenseid) {
		return expenseService.readExpenseByExpenseid(expenseid);
	}
	
	//Get List of Expenses by userid
	@GetMapping(value = "/userid/{userid}")
	@CrossOrigin(origins = LOCALHOST)
	public List<Expense> getExpensesByExpenseid(@PathVariable long userid) {
		return expenseService.readExpensesByUserid(userid);
	}
	
	//Get Summary of Expense for user by userid
	@GetMapping(value = "/summary", produces = JSON, consumes = JSON)
	@CrossOrigin(origins = LOCALHOST)
	public ExpenseSummary getExpenseSummary( @RequestBody ExpenseSummaryRequest request) {
		return expenseService.getExpenseSummary(request);
	}
	
	//Get Summary of Expense for user by userid with path variables
	@GetMapping(value = "/summary/userid/{userid}/month/{monthCode}/year/{year}", produces = JSON)
	@CrossOrigin(origins = LOCALHOST)
	public ExpenseSummary getExpenseSummary(@PathVariable long userid, @PathVariable int monthCode, @PathVariable int year) {
		ExpenseSummaryRequest request = new ExpenseSummaryRequest(userid, monthCode, year);
		return expenseService.getExpenseSummary(request);
		
	}
	
	
	//Post create a new Expense
	@PostMapping(value = "/create", consumes = JSON, produces = JSON)
	@CrossOrigin(origins = LOCALHOST)
	public Expense createExpense(@RequestBody Expense expense) {
		expense = expenseService.createExpense(expense);
		return expense;
	}
	
	//Put update Expense
	@PutMapping(value = "/update/{expenseid}", consumes = JSON, produces = JSON)
	@CrossOrigin(origins = LOCALHOST)
	public Expense updateExpense(@PathVariable long expenseid, @RequestBody Expense expense) {
		Expense existingExpense = expenseService.readExpenseByExpenseid(expenseid);
		
		if(existingExpense != null) {
			existingExpense.setAmount(expense.getAmount());
			existingExpense.setCategory(expense.getCategory());
			existingExpense.setDate(expense.getDate());
			existingExpense.setDescription(expense.getDescription());
			existingExpense.setUserid(expense.getUserid());
			expenseService.updateExpense(existingExpense);
			return existingExpense;
		} else {
			return null;
		}
	}
	
	//Delete an expense by id
	@DeleteMapping(value = "/delete/{expenseid}")
	@CrossOrigin(origins = LOCALHOST)
	public void deleteExpense(@PathVariable long expenseid) {
		expenseService.deleteExpenseByExpenseid(expenseid);
	}
	
	//Delete expense by list of ids.
	@DeleteMapping(value = "/delete/expenses", consumes = JSON)
	@CrossOrigin(origins = LOCALHOST)
	public void deleteExpense(@RequestBody List<Long> expenseids) {
		expenseService.deleteExpensesByExpenseidIn(expenseids);
	}
	
	
	
}
