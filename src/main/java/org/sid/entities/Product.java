package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Product implements Serializable{
	@Id @GeneratedValue
	private long id;
	@NotNull
	@Size(min = 4, max = 30)
	private String designation;
	@DecimalMin("100")
	private double price;
	@Min(value = 20 , message = "La valeur ne doit pas être inférieure à 2")
    @Max(value = 180 , message = "La valeur ne doit pas être supérieure à 180")
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
