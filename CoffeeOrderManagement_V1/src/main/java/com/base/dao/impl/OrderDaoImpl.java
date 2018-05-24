package com.base.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.base.dao.OrderDao;
import com.base.repos.OrderRepository;

@Component
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	private OrderRepository orderRepository;

}
