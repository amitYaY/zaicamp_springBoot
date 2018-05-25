package com.base.listener.entity;

import javax.persistence.PostUpdate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.base.domain.CoffeeMachine;

public class OderListener {

	Logger logger = LoggerFactory.getLogger(OderListener.class);
	
	@PostUpdate
	public void checkUpdatedAttribute(CoffeeMachine coffeeMachine) {
		logger.info(" OderListener for update called");
			
	}
}
