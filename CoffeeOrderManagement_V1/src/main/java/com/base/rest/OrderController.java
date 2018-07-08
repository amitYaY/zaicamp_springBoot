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

import com.base.domain.Order;
import com.base.service.OrderSevice;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "APIs to manage Orders")
@RestController
@RequestMapping("/api/order")
public class OrderController {

	private Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderSevice orderSevice;

	@RequestMapping(path = "/orders", method = RequestMethod.GET)
	@ApiOperation(value = "Get All Orders", notes = "This API will return List of Orders")
	public List<Order> getOrders(
			@ApiParam(value = "OrderId", name = "OrderId", required = false) @RequestParam(required = false) String orderId) {
		logger.info(">>> getOrders API.");
		List<Order> orders = orderSevice.getAllOrders();
		logger.debug("-- OrderList Size: "+(orders != null ? orders.size():0));
		logger.info("<<< getOrders API.");
		return orders;
	}

	@RequestMapping(path = "/orders", method = RequestMethod.POST)
	@ApiOperation(value = "Create Order", notes = "This API will create Order")
	public String createOrder(
			@ApiParam(value = "Order", name = "Order", required = true) @RequestBody(required = true) Order order) {
		String response = "SUCCESS";
		logger.info(">>> createOrder API.");
		Order orderResponse = orderSevice.saveOrder(order);
		if(orderResponse == null) {
			response = "ERROR";
		}
		logger.info("<<< createOrder API.");
		return response;
	}
	
}
