package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Product implements Serializable{
	@Id @GeneratedValue
	private long id;
	@NotNull
	@Size(min = 4, max = 15)
	private String designation;
	@DecimalMin("100")
	private double price;
	private int amount;
	
	public Product() {
		super();
	}
	
	public Product(String designation, double price, int amount) {
		super();
		this.designation = designation;
		this.price = price;
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
