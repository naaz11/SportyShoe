package com.simplilearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_data")
 
public class Shoe {
	@Id
	@GeneratedValue
	@Column(name="shoe_id")
	private int id;
	
	@Column(name="shoe_name")
	private String Product_name;
	
	@Column(name="shoe_price")
	private int Price;
	
	@Column(name="shoe_category")
	private String Category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_name() {
		return Product_name;
	}

	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

}
	

	