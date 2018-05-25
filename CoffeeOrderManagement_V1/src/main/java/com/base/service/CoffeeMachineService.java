package com.base.service;

import com.base.domain.CoffeeMachine;

public interface CoffeeMachineService {
	
	public abstract void saveMachine(CoffeeMachine machine);
	
	public abstract void updateMachine(CoffeeMachine machine);
	
	public abstract Iterable<CoffeeMachine> getAllMachine();

}
