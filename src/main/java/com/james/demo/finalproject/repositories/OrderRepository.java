package com.james.demo.finalproject.repositories;

// Copyright 2016-2018 Diffblue Limited. All rights reserved.

import com.james.demo.finalproject.models.Order;
import org.springframework.data.repository.Repository;

public interface OrderRepository extends Repository<Order, Integer> {

  /**
   * Adds new entry to the orders table.
   */
  Order save(Order order);
}
