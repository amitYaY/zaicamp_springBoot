package com.base.service;

import java.util.List;

import com.base.domain.Order;

public interface OrderSevice {

	public abstract Order saveOrder(Order order);

	public abstract Order updateOrder(Order order);

	public abstract List<Order> getAllOrders();

}
