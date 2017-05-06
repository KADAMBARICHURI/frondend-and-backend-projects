package com.niit.shoppingcart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import org.springframework.stereotype.Component;

@Entity   // to map the data base table
@Table(name ="User")  //if the table name and domain class name is different
@Component   //context.scan("com.niit") --will scan the package and create singleton instances
public class User {
	
	//we have define all properties for all the fields in table.
	
	
	//we have mention which one is primary key
	@Id
	private String id;
	
	@Column(name="name")  // if the field name in table and property name in class is
							// different, then we required specify column name
		                   // Otherwise no need specify
	private String name;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	//@Min(2)
	//@Max(15)
	private String password;
	
	private String contact;
	
	private String role;
	
	

}
