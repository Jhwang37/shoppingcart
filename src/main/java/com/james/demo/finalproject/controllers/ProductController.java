package com.james.demo.finalproject.controllers;



import com.james.demo.finalproject.Application;
import com.james.demo.finalproject.exceptions.InvalidCategoryException;
import com.james.demo.finalproject.models.Category;
import com.james.demo.finalproject.models.Product;
import com.james.demo.finalproject.repositories.CategoryRepository;
import com.james.demo.finalproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Controller for getting product information from the DB.
 * productList will get the names of all the products that are currently held in the DB
 */

@Controller
public class ProductController {

  private final CategoryRepository categoryRepo;
  private final ProductRepository productRepo;

  @Autowired
  public ProductController(CategoryRepository categoryRepo2, ProductRepository productRepo2) {
    this.categoryRepo = categoryRepo2;
    this.productRepo = productRepo2;
  }

  /**
   * Get the full list of products.

   */

  @RequestMapping("/ProductList")
  public String productList(Map<String, Object> model) {

    Iterable<Product> allProducts = this.productRepo.findAll();
    Application.log.info("All Products as string: " + allProducts.toString());
    model.put("products", allProducts);
    return "ProductList";
  }

  /**
   * Get a list of products with the specified category.

   */

  @RequestMapping("/ProductList/{category}")
  public String productList(@PathVariable("category") String category, Map<String, Object> model) {
    Category cat = this.categoryRepo.findByName(category);
    try {
      if (cat != null) {
        Iterable<Product> allProducts = this.productRepo.findByCategory(cat);
        model.put("products", allProducts);
        return "ProductList";
      } else {
        throw new InvalidCategoryException(404, "No category entitled '" + category + "' exists.");
      }
    } catch (InvalidCategoryException e) {
      Application.log.info(e.getMessage());
      return "redirect:/exception";
    }
  }

  /**
   * Get a given product data to display on the product page.

   */
  @RequestMapping("/product/{id}")
  public String productPage(@PathVariable("id") int id, Map<String, Object> model) {
    Product prod = this.productRepo.findById(id);
    if (prod != null) {
      Application.log.info("Product as string: " + prod.toString());
      model.put("product", prod);
      return "ProductPage";
    } else {
      Application.log.info("Unknown product id provided: " + id);
      return "redirect:/ProductList";
    }
  }
}
