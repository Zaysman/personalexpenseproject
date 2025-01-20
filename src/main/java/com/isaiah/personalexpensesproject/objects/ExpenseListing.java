package com.isaiah.personalexpensesproject.objects;

public class ExpenseListing {
	
	
	private String category; //The category of the listing that is being stored.
	private double amount; //The amount for that category.
	
	public ExpenseListing() {
		this("default category", 0.0);
	}
	
	public ExpenseListing(String category, double amount) {
		super();
		this.category = category;
		this.amount = amount;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "ExpenseListing [category=" + category + ", amount=" + amount + "]";
	}
}
