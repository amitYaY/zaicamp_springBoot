package com.base.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.base.dao.CoffeeMachineDao;
import com.base.domain.CoffeeMachine;
import com.base.repos.CoffeeMachineRepository;

@Component
public class CoffeeMachineDaoImpl implements CoffeeMachineDao {

	private Logger logger = LoggerFactory.getLogger(CoffeeMachineDaoImpl.class);
	
	@Autowired
	private CoffeeMachineRepository coffeeMachineRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

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
	
	@Override
	public CoffeeMachine getAvailableMachine(Double qtyCoffeeBeans, Double qtyOfWater) {
		logger.info(">>>> getAvailableMachine Entered.");
		CoffeeMachine availableMachine = null;
		String query = "SELECT * FROM COFFEE_MACHINE WHERE COFFEEBEANS_QUANTITY >= ? AND MILK_QUANTITY >= ?";
		List<CoffeeMachine> list = jdbcTemplate.queryForList(query, new Object[]{qtyCoffeeBeans, qtyOfWater}, CoffeeMachine.class);
		if(!list.isEmpty()) {
			availableMachine = list.get(0);
		}
		logger.info("<<<< getAvailableMachine Exited.");
		return availableMachine;
	}
	
}