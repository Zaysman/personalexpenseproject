package com.isaiah.personalexpensesproject.objects;

public class ExpenseSummaryRequest {
	
	private long userid; //User id of the user whose requesting the summary.
	private int monthCode; //Code for the month we're sending
	private int year; //The year the summary is being requested.
	
	
	public ExpenseSummaryRequest() {
		this(-1, -1, -1);
	}
	
	public ExpenseSummaryRequest(long userid, int monthCode, int year) {
		super();
		this.userid = userid;
		this.monthCode = monthCode;
		this.year = year;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public int getMonthCode() {
		return monthCode;
	}

	public void setMonthCode(int monthCode) {
		this.monthCode = monthCode;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "ExpenseSummaryRequest [userid=" + userid + ", monthCode=" + monthCode + ", year=" + year + "]";
	}

}
