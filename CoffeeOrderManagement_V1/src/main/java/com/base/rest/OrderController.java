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

@Api(value = "APIs to manage Orders")
@RestController
@RequestMapping("/api/order")
public class OrderController {

	Logger logger = LoggerFactory.getLogger(OrderController.class);

	@RequestMapping(path = "/orders", method = RequestMethod.GET)
	@ApiOperation(value = "Get All Orders", notes = "This API will return List of Orders")
	public List<Order> getOrders(
			@ApiParam(value = "OrderId", name = "OrderId", required = false) @RequestParam(required = false) String orderId) {
		logger.info(">>> getOrders API.");
		
		logger.info("<<< getOrders API.");
		return null;
	}

}
