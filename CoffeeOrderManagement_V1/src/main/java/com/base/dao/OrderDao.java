package com.base.dao;

import com.base.domain.Order;

public interface OrderDao {

	public abstract Order saveOrder(Order order);

	public abstract Order updateOrder(Order order);

	public abstract Iterable<Order> getAllOrders();
	
}
