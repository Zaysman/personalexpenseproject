package com.isaiah.personalexpensesproject.objects;

import java.time.LocalDate;

public class Expense {
	
	private long expenseid;
	private long userid;
	private float amount;
	private LocalDate date;
	private String category;
	private String description;
	
	
	public Expense() {
		this(-1, -1, 0.0f, LocalDate.now(), "", "");
	}
	
	
	public Expense(long expenseid, long userid, float amount, LocalDate date, String category, String description) {
		super();
		this.expenseid = expenseid;
		this.userid = userid;
		this.amount = amount;
		this.date = date;
		this.category = category;
		this.description = description;
	}


	public long getExpenseid() {
		return expenseid;
	}


	public void setExpenseid(long expenseid) {
		this.expenseid = expenseid;
	}


	public long getUserid() {
		return userid;
	}


	public void setUserid(long userid) {
		this.userid = userid;
	}


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Expense [expenseid=" + expenseid + ", userid=" + userid + ", amount=" + amount + ", date=" + date
				+ ", category=" + category + ", description=" + description + "]";
	}

}
