package com.james.demo.finalproject.repositories;

// Copyright 2016-2018 Diffblue Limited. All rights reserved.

import com.james.demo.finalproject.models.Category;
import com.james.demo.finalproject.models.Product;
import org.springframework.data.repository.Repository;


public interface ProductRepository extends Repository<Product, Integer> {

  /**
   * Provides access to the database for product information.
   * The following items are available:
   *  findName - returns all of the names of the products
   */
  
  Iterable<Product> findAll();
  
  Iterable<Product> findByCategory(Category category);

  /**
   * Provides access to a given product information from the database.
   */
  Product findById(int id);
}
