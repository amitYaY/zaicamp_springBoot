package com.base.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	public CoffeeMachine saveMachine(CoffeeMachine machine) {
		logger.info(">>>> saveMachine Entered.");
		CoffeeMachine machineResponse = coffeeMachineDao.saveMachine(machine);
		logger.info("<<<< saveMachine Exited.");
		return machineResponse;
	}

	@Override
	public CoffeeMachine updateMachine(CoffeeMachine machine) {
		logger.info(">>>> updateMachine Entered.");
		CoffeeMachine machineResponse = coffeeMachineDao.updateMachine(machine);
		logger.info("<<<< updateMachine Exited.");
		return machineResponse;
		
	}

	@Override
	public List<CoffeeMachine> getAllMachine() {
		logger.info(">>>> getMachine Entered.");
		Iterable<CoffeeMachine> machines = coffeeMachineDao.getAllMachine();
		Iterator<CoffeeMachine> iterator = machines.iterator();
		List<CoffeeMachine> machinerList = new ArrayList<>();
		iterator.forEachRemaining(machinerList::add);
		logger.info("<<<< getMachine Exited.");
		return machinerList;
	}
	
}
