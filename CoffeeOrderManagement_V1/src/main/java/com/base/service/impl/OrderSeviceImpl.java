package com.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.base.dao.OrderDao;
import com.base.service.OrderSevice;

@Component
public class OrderSeviceImpl implements OrderSevice {
	
	@Autowired
	private OrderDao orderDao;

}
