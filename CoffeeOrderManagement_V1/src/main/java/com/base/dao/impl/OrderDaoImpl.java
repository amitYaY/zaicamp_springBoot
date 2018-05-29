package com.base.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.base.dao.OrderDao;
import com.base.domain.Order;
import com.base.repos.OrderRepository;

@Component
public class OrderDaoImpl implements OrderDao {
	
	private Logger logger = LoggerFactory.getLogger(OrderDaoImpl.class);
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order saveOrder(Order order) {
		logger.info(">>>> saveOrder Entered.");
		Order orderResponse = orderRepository.save(order);
		logger.info("<<<< saveOrder Exited.");
		return orderResponse;
	}

	@Override
	public Order updateOrder(Order order) {
		logger.info(">>>> updateOrder Entered.");
		Order orderResponse = orderRepository.save(order);
		logger.info("<<<< updateOrder Exited.");
		return orderResponse;
	}

	@Override
	public Iterable<Order> getAllOrders() {
		logger.info(">>>> getAllOrders Entered.");
		Iterable<Order> orders = orderRepository.findAll();
		logger.info("<<<< getAllOrders Exited.");
		return orders;
	}
	
}
