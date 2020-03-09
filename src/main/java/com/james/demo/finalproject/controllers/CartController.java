package com.james.demo.finalproject.controllers;



import com.james.demo.finalproject.Application;
import com.james.demo.finalproject.models.Cart;
import com.james.demo.finalproject.models.Product;
import com.james.demo.finalproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CartController {

  private final ProductRepository productRepo;

  @Autowired
  public CartController(ProductRepository productRepo) {
    this.productRepo = productRepo;
  }

  /**
   * Get the cart data and display it on the cart view page.

   */

  @RequestMapping("/cart")
  public String viewCart(Map<String, Object> model, HttpSession session) {
    Cart shoppingCart = getOrCreateSessionCart(session);
    model.put("cart", shoppingCart);
    return "Cart";
  }

  /**
   * Add product to cart.

   */
  @PostMapping("/addToCart")
  public String addToCart(@ModelAttribute Product product, HttpSession session,
                          @RequestParam String size) {

    Product prod = this.productRepo.findById(product.getId());
    prod.setSize(size);
    if (prod != null) {
      Cart shoppingCart = getOrCreateSessionCart(session);
      shoppingCart.addProduct(prod);
      session.setAttribute("shoppingCart",shoppingCart);
    }

    return "redirect:/cart";
  }

  /**
   * Remove a given product from the cart.

   */
  @RequestMapping("/removeFromCart/{id}/size/{size}")
  public String removeFromCart(@PathVariable("id") int id, HttpSession session,
                               @PathVariable("size") String size) {
    return this.updateCart(id, 0, session, size);
  }

  /**
   * Update a given product quantity in the cart.

   */
  @PostMapping("/updateCartItem")
  public String updateCartItem(HttpServletRequest request, HttpSession session) {
    int id = Integer.parseInt(request.getParameter("product_id"));
    int newQty = Integer.parseInt(request.getParameter("quantity"));
    String size = request.getParameter("size");
    return this.updateCart(id, newQty, session, size);
  }

  /**
   * Update a given product quantity in the cart.

   */
  public String updateCart(int productId, int quantity, HttpSession session, String size) {
    Product prod = this.productRepo.findById(productId);
    if (prod != null) {
      Cart shoppingCart = this.getSessionCart(session);
      if (shoppingCart != null) {
        shoppingCart.updateProductQuantity(prod, quantity, size);
        session.setAttribute("shoppingCart",shoppingCart);
      }
    } else {
      Application.log.info("Unknown product id provided: " + productId);
    }
    return "redirect:/cart";
  }


  /**
   * Get cart in current session.

   */
  public Cart getSessionCart(HttpSession session) {
    Cart shoppingCart = null;
    if (session.getAttribute("shoppingCart") != null) {
      shoppingCart = (Cart) session.getAttribute("shoppingCart");
    }
    return shoppingCart;
  }

  /**
   * Get cart in current session, or create one if doesn't exist.

   */
  public Cart getOrCreateSessionCart(HttpSession session) {

    Cart shoppingCart = getSessionCart(session);
    if (shoppingCart == null) {
      shoppingCart = new Cart();
    }

    return shoppingCart;
  }

}
