package com.base.listener.entity;

import javax.persistence.PostUpdate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.base.domain.CoffeeMachine;

public class CoffeeMachineListener {
	
	Logger logger = LoggerFactory.getLogger(CoffeeMachineListener.class);

	@PostUpdate
	public void checkUpdatedAttribute(CoffeeMachine coffeeMachine) {
		logger.info(" CoffeeMachineListener for update called");
	}
	
}
