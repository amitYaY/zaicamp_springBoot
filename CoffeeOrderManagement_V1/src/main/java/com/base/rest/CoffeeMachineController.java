package com.base.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.base.domain.CoffeeMachine;
import com.base.service.CoffeeMachineService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "APIs to manage Coffee Machines")
@RestController
@RequestMapping("/api/machine")
public class CoffeeMachineController {
	
	private Logger logger = LoggerFactory.getLogger(CoffeeMachineController.class);
	
	@Autowired
	private CoffeeMachineService coffeeMachineService;

	@RequestMapping(path = "/machines", method = RequestMethod.GET)
	@ApiOperation(value = "Get All Machines", notes = "This API will return List of Coffee Machines")
	public List<CoffeeMachine> getOrders(
			@ApiParam(value = "MachineId", name = "MachineId", required = false) @RequestParam(required = false) String machineId) {
		logger.info(">>> getMachines API.");
		List<CoffeeMachine> machines = coffeeMachineService.getAllMachine();
		logger.debug("-- MachineList Size: "+(machines != null ? machines.size():0));
		logger.info("<<< getMachines API.");
		return machines;
	}
	
	@RequestMapping(path = "/machines", method = RequestMethod.POST)
	@ApiOperation(value = "Create Machines", notes = "This API will create Machine")
	public String createMachine(
			@ApiParam(value = "Machine", name = "Machine", required = true) @RequestBody(required = true) CoffeeMachine machine) {
		String response = "SUCCESS";
		logger.info(">>> createMachine API.");
		CoffeeMachine machineResponse = coffeeMachineService.saveMachine(machine);
		if(machineResponse == null) {
			response = "ERROR";
		}
		logger.info("<<< createMachine API.");
		return response;
	}
}
