package com.base.dao;

import com.base.domain.CoffeeMachine;

public interface CoffeeMachineDao {

	public abstract void saveMachine(CoffeeMachine machine);

	public abstract void updateMachine(CoffeeMachine machine);

	public abstract Iterable<CoffeeMachine> getAllMachine();
	
}