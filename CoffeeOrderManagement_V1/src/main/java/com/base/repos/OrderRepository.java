package com.base.repos;

import org.springframework.data.repository.CrudRepository;

import com.base.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>{

}
