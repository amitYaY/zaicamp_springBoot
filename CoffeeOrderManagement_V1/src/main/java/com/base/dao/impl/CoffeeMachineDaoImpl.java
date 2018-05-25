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
	public void saveMachine(CoffeeMachine machine) {
		logger.info(">>>> saveMachine Entered.");
		coffeeMachineRepository.save(machine);
		logger.info("<<<< saveMachine Exited.");
	}

	@Override
	public void updateMachine(CoffeeMachine machine) {
		logger.info(">>>> updateMachine Entered.");
		coffeeMachineRepository.save(machine);
		logger.info("<<<< updateMachine Exited.");
	}

	@Override
	public Iterable<CoffeeMachine> getAllMachine() {
		logger.info(">>>> getMachine Entered.");
		Iterable<CoffeeMachine> machines = coffeeMachineRepository.findAll();
		logger.info("<<<< getMachine Exited.");
		return machines;
	}
	
}