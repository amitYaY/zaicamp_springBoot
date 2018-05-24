package com.base.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COFFEE_MACHINE")
@Access(AccessType.FIELD)
public class CoffeeMachine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int machineId;

	@Column(name = "COFFEEBEANS_QUANTITY")
	private Double quantityOfCoffeeBeans;

	@Column(name = "MILK_QUANTITY")
	private Double quantityOfMilk;

	@Column(name = "WATER_QUANTITY")
	private Double quantityOfWater;

	@Column(name = "MCHINE_STATUS")
	private String status;

	public int getMachineId() {
		return machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}

	public Double getQuantityOfCoffeeBeans() {
		return quantityOfCoffeeBeans;
	}

	public void setQuantityOfCoffeeBeans(Double quantityOfCoffeeBeans) {
		this.quantityOfCoffeeBeans = quantityOfCoffeeBeans;
	}

	public Double getQuantityOfMilk() {
		return quantityOfMilk;
	}

	public void setQuantityOfMilk(Double quantityOfMilk) {
		this.quantityOfMilk = quantityOfMilk;
	}

	public Double getQuantityOfWater() {
		return quantityOfWater;
	}

	public void setQuantityOfWater(Double quantityOfWater) {
		this.quantityOfWater = quantityOfWater;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
