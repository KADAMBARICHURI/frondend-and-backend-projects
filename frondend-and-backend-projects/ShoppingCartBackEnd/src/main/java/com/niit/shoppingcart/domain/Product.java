package com.niit.shoppingcart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity   // to map the data base table
@Table(name ="Product")  //if the table name and domain class name is different
@Component   //context.scan("com.niit") --will scan the package and create singleton instances
public class Product {
	
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

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}


	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}


	public String getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}


	private String description;
	
	private String price;
	@Column(name="category_id")
	private String categoryID;
	@Column(name="supplier_id")
	private String supplierID;


		

	
	

}

