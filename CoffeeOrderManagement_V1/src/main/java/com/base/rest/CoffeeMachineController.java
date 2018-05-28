package com.base.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.base.domain.Order;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "APIs to manage Coffee Machines")
@RestController
@RequestMapping("/api/machine")
public class CoffeeMachineController {
	
	Logger logger = LoggerFactory.getLogger(CoffeeMachineController.class);

	@RequestMapping(path = "/machines", method = RequestMethod.GET)
	@ApiOperation(value = "Get All Machines", notes = "This API will return List of Coffee Machines")
	public List<Order> getOrders(
			@ApiParam(value = "MachineId", name = "MachineId", required = false) @RequestParam(required = false) String machineId) {
		logger.info(">>> getMachines API.");
		
		logger.info("<<< getMachines API.");
		return null;
	}

}
