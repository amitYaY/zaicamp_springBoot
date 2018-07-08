package com.base.listener.entity;

import javax.persistence.PostLoad;
import javax.persistence.PostUpdate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.base.domain.Order;

public class OrderListener {

	Logger logger = LoggerFactory.getLogger(OrderListener.class);
	
	private int orderOldStatus;
	
	@PostLoad
	public void orderPreUpdate(Order order) {
		logger.info("OrderPreUpdate called");
		this.orderOldStatus = order.getStatus();	
	}
	
	@PostUpdate
	public void orderPostUpdate(Order order) {
		logger.info("OrderPostUpdate called");
		int orderNewStatus = order.getStatus();
		if(orderOldStatus != orderNewStatus) {
			logger.warn("Order Status Changed: orderOldStatus: "+orderOldStatus+" orderNewStatus: "+orderNewStatus);
		}
	}
	
}
