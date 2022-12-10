package com.simplilearn.entity;

//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SalesRecord")
public class SalesRecord {
	
	@Id
	@GeneratedValue
	@Column(name="sales_id")
	private int id;
	@Column(name="product_category")
	private String category;
	@Column(name="product_name")
	private String shoe_name;
	@Column(name="Buyer")
	private String user_name;
	@Column(name="date")
	private String saledate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getShoe_name() {
		return shoe_name;
	}
	public void setShoe_name(String shoe_name) {
		this.shoe_name = shoe_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getSaledate() {
		return saledate;
	}
	public void setSaledate(String saledate) {
		this.saledate = saledate;
	}
	
	

}
