package com.isaiah.personalexpensesproject.objects;

import jakarta.persistence.*;

@Entity
@Table(name="categories", uniqueConstraints = @UniqueConstraint(columnNames = "categoryentryid"))
public class CustomCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //The database will determine the ID for the object.
	@Column(name = "categoryentryid")
	private long categoryentryid;
	
	@Column(name = "userid")
	private long userid;
	
	@Column(name = "category")
	private String categoryName;
	
	public CustomCategory() {
		this(-1, -1, "default name");
	}

	public CustomCategory(long categoryentryid, long userid, String categoryName) {
		super();
		this.categoryentryid = categoryentryid;
		this.userid = userid;
		this.categoryName = categoryName;
	}

	public long getCategoryentryid() {
		return categoryentryid;
	}

	public void setCategoryentryid(long categoryentryid) {
		this.categoryentryid = categoryentryid;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "CustomCategory [categoryentryid=" + categoryentryid + ", userid=" + userid + ", categoryName="
				+ categoryName + "]";
	}
	
	

}
