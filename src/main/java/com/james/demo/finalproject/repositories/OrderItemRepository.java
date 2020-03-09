package com.james.demo.finalproject.repositories;

// Copyright 2016-2018 Diffblue Limited. All rights reserved.

import com.james.demo.finalproject.models.OrderItem;
import org.springframework.data.repository.Repository;

public interface OrderItemRepository extends Repository<OrderItem, Integer> {

  /**
   * Adds new entry to the order items table.
   */
  OrderItem save(OrderItem order);
}
