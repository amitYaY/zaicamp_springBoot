package com.base.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.base.dao.CoffeeMachineDao;
import com.base.domain.CoffeeMachine;
import com.base.repos.CoffeeMachineRepository;

@Component
public class CoffeeMachineDaoImpl implements CoffeeMachineDao {

	private Logger logger = LoggerFactory.getLogger(CoffeeMachineDaoImpl.class);
	
	@Autowired
	private CoffeeMachineRepository coffeeMachineRepository;

	@Override
	public CoffeeMachine saveMachine(CoffeeMachine machine) {
		logger.info(">>>> saveMachine Entered.");
		CoffeeMachine machineResponse = coffeeMachineRepository.save(machine);
		logger.info("<<<< saveMachine Exited.");
		return machineResponse;
	}

	@Override
	public CoffeeMachine updateMachine(CoffeeMachine machine) {
		logger.info(">>>> updateMachine Entered.");
		CoffeeMachine machineResponse = coffeeMachineRepository.save(machine);
		logger.info("<<<< updateMachine Exited.");
		return machineResponse;
	}

	@Override
	public Iterable<CoffeeMachine> getAllMachine() {
		logger.info(">>>> getAllMachine Entered.");
		Iterable<CoffeeMachine> machines = coffeeMachineRepository.findAll();
		logger.info("<<<< getAllMachine Exited.");
		return machines;
	}
	
}