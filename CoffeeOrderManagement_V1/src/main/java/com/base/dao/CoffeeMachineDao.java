package com.base.dao;

import com.base.domain.CoffeeMachine;

public interface CoffeeMachineDao {

	public abstract CoffeeMachine saveMachine(CoffeeMachine machine);

	public abstract CoffeeMachine updateMachine(CoffeeMachine machine);

	public abstract Iterable<CoffeeMachine> getAllMachine();
	
}