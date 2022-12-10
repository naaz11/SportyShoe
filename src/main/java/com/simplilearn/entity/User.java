package com.simplilearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_List")
public class User {
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int Id;
	
	@Column(name="user_name")
	private String username;
	
	@Column(name="user_password")
	private String Password;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return username;
	}

	public void setName(String name) {
		username = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	
}
