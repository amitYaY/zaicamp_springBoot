package com.base.dao;

import com.base.domain.CoffeeMachine;

public interface CoffeeMachineDao {

	public CoffeeMachine saveMachine(CoffeeMachine machine);

	public CoffeeMachine updateMachine(CoffeeMachine machine);

	public Iterable<CoffeeMachine> getAllMachine();
	
	public CoffeeMachine getAvailableMachine(Double qtyCoffeeBeans, Double qtyOfWater);
	
}