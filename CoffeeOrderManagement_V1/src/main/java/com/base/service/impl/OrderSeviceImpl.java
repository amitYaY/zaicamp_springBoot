package com.base.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.base.dao.CoffeeMachineDao;
import com.base.dao.OrderDao;
import com.base.domain.CoffeeMachine;
import com.base.domain.Order;
import com.base.service.OrderSevice;
import com.base.util.constants.OrderStatus;

@Component
public class OrderSeviceImpl implements OrderSevice {
	
	private Logger logger = LoggerFactory.getLogger(OrderSeviceImpl.class);
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private CoffeeMachineDao coffeeMachineDao;
	
	@Autowired
	private Environment environment;
	
	@Override
	@Transactional
	public Order saveOrder(Order order) {
		logger.info(">>>> saveOrder Entered.");
		
		Order orderResponse = null;
		if (order != null) {
			String type = order.getCoffeeType();
			int quantity = order.getQuantity();
			String beanPropKey = "order.type.beans." + type;
			double beanAmnt = quantity * Integer.valueOf(environment.getProperty(beanPropKey));
			String milkPropKey = "order.type.milk." + type;
			double milkAmnt = quantity * Integer.valueOf(environment.getProperty(milkPropKey));
			CoffeeMachine machine = coffeeMachineDao.getAvailableMachine(beanAmnt, milkAmnt);
			if (machine != null) {
				order.setMachine(machine);
				order.setStatus(OrderStatus.CREATED.getValue());
				orderResponse = orderDao.saveOrder(order);
				machine.setQuantityOfCoffeeBeans(machine.getQuantityOfCoffeeBeans() - beanAmnt);
				machine.setQuantityOfMilk(machine.getQuantityOfMilk() - milkAmnt);
				if (machine.getOrders() != null) {
					machine.getOrders().add(order);
				} else {
					List<Order> orders = new ArrayList<>();
					orders.add(order);
					machine.setOrders(orders);
				}
				coffeeMachineDao.saveMachine(machine);
			}
		}
		
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
