package com.isaiah.personalexpensesproject.objects;

import java.util.ArrayList;
import java.util.List;

public class ExpenseSummary {
	
	private double Total; //The total sum of all expenses we retrieve from the backend.
	
	private List<ExpenseListing> listings = new ArrayList<>(); //Array List that will hold each ExpenseListing.
	
	public double getTotal() {
		return Total;
	}

	public void setTotal(double total) {
		Total = total;
	}

	public List<ExpenseListing> getListings() {
		return listings;
	}

	public void setListings(List<ExpenseListing> listings) {
		this.listings = listings;
	}
	

}
