package com.isaiah.personalexpensesproject.repositories;

import com.isaiah.personalexpensesproject.objects.Expense;
import com.isaiah.personalexpensesproject.objects.ExpenseListing;
import com.isaiah.personalexpensesproject.objects.ExpenseSummaryRequest;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


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
	
	//Run query to retrieve the data for the Expense Summary.
	//@Query("select e.category, sum(e.amount) from Expense e where e.userid = :userid and Month(e.date) = :month and year(e.date) = :year group by e.category")
	//@Query("SELECT new com.isaiah.personalexpensesproject.objects.ExpenseListing(e.category, e.amount) FROM Expense e WHERE e.userid = :userid and Month(e.date) = :month and year(e.date) = :year group by e.category")
	@Query("SELECT new com.isaiah.personalexpensesproject.objects.ExpenseListing(e.category, SUM(e.amount)) " +
		       "FROM Expense e " +
		       "WHERE e.userid = :userid AND Month(e.date) = :month AND Year(e.date) = :year " +
		       "GROUP BY e.category")
	List<ExpenseListing> generateMonthlySummary(@Param("userid") long userid, @Param("month") int month, @Param("year") int year);

	
	
	//Run query to retrieve the total sum for the Expense Summary
	@Query("select sum(amount) from Expense e where Month(e.date) = :month and year(e.date) = :year")
	Double generateMonthlySummaryTotalAmount(@Param("month") int month, @Param("year") int year);

}
