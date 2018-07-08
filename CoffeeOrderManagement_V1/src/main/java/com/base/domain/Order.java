package com.base.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.base.listener.entity.OrderListener;

@Entity
@Table(name = "COFFEE_ORDER")
@EntityListeners(value = {OrderListener.class})
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name="TYPE")
	private String coffeeType;
	
	@Column(name="QUANTITY")
	private int quantity;
	
	@Column(name="STATUS")
	private int status;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade= {CascadeType.ALL})
	@JoinTable(name = "ORDER_MACHINE", joinColumns = {@JoinColumn(name="ID")}, inverseJoinColumns = {@JoinColumn(name = "MACHINE_ID")})
	private CoffeeMachine machineId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCoffeeType() {
		return coffeeType;
	}

	public void setCoffeeType(String coffeeType) {
		this.coffeeType = coffeeType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public CoffeeMachine getMachine() {
		return machineId;
	}

	public void setMachine(CoffeeMachine machineId) {
		this.machineId = machineId;
	}
	
}
