package com.base.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.base.dao.OrderDao;
import com.base.domain.Order;
import com.base.service.OrderSevice;

@Component
public class OrderSeviceImpl implements OrderSevice {
	
	private Logger logger = LoggerFactory.getLogger(OrderSeviceImpl.class);
	
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public Order saveOrder(Order order) {
		logger.info(">>>> saveOrder Entered.");
		Order orderResponse = orderDao.saveOrder(order);
		logger.info("<<<< saveOrder Exited.");
		return orderResponse;
	}

	@Override
	public Order updateOrder(Order order) {
		logger.info(">>>> updateOrder Entered.");
		Order orderResponse = orderDao.updateOrder(order);
		logger.info("<<<< updateOrder Exited.");
		return orderResponse;
	}

	@Override
	public List<Order> getAllOrders() {
		logger.info(">>>> getAllOrders Entered.");
		Iterable<Order> orders = orderDao.getAllOrders();
		Iterator<Order> iterator = orders.iterator();
		List<Order> orderList = new ArrayList<>();
		iterator.forEachRemaining(orderList::add);
		logger.info("<<<< getAllOrders Exited.");
		return orderList;
	}

}
