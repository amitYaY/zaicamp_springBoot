package com.base.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.base.dao.CoffeeMachineDao;
import com.base.domain.CoffeeMachine;
import com.base.service.CoffeeMachineService;

@Component
public class CoffeeMachineServiceImpl implements CoffeeMachineService {

	private Logger logger = LoggerFactory.getLogger(CoffeeMachineServiceImpl.class);
	
	@Autowired
	private CoffeeMachineDao coffeeMachineDao;

	@Override
	public void saveMachine(CoffeeMachine machine) {
		logger.info(">>>> saveMachine Entered.");
		coffeeMachineDao.saveMachine(machine);
		logger.info("<<<< saveMachine Exited.");
	}
}
