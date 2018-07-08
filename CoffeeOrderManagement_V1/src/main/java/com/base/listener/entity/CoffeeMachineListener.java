package com.base.listener.entity;

import javax.persistence.PostLoad;
import javax.persistence.PostUpdate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.base.domain.CoffeeMachine;

public class CoffeeMachineListener {
	
	Logger logger = LoggerFactory.getLogger(CoffeeMachineListener.class);
	
	private String machineOldStatus;

	@PostLoad
	public void machinePreUpdate(CoffeeMachine coffeeMachine) {
		logger.info("machinePreUpdate called");
		this.machineOldStatus = coffeeMachine.getStatus();	
	}
	
	@PostUpdate
	public void machinePostUpdate(CoffeeMachine coffeeMachine) {
		logger.info("machinePostUpdate called");
		String machineNewStatus = coffeeMachine.getStatus();
		if(machineOldStatus != machineNewStatus) {
			logger.warn("CoffeeMachine Status Changed: machineOldStatus: "+machineOldStatus+" machineNewStatus: "+machineNewStatus);
		}
	}
}
