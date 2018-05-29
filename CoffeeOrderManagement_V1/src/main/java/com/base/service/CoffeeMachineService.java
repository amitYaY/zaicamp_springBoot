package com.base.service;

import java.util.List;

import com.base.domain.CoffeeMachine;

public interface CoffeeMachineService {
	
	public abstract CoffeeMachine saveMachine(CoffeeMachine machine);
	
	public abstract CoffeeMachine updateMachine(CoffeeMachine machine);
	
	public abstract List<CoffeeMachine> getAllMachine();

}
