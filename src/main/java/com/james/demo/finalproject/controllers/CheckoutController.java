package com.james.demo.finalproject.controllers;



import com.james.demo.finalproject.Application;
import com.james.demo.finalproject.exceptions.EmptyCartException;
import com.james.demo.finalproject.exceptions.InvalidCartItemException;
import com.james.demo.finalproject.forms.AddressForm;
import com.james.demo.finalproject.forms.CustomerForm;
import com.james.demo.finalproject.forms.PaymentForm;
import com.james.demo.finalproject.models.Address;
import com.james.demo.finalproject.models.Cart;
import com.james.demo.finalproject.models.Order;
import com.james.demo.finalproject.models.OrderItem;
import com.james.demo.finalproject.models.Product;
import com.james.demo.finalproject.repositories.AddressRepository;
import com.james.demo.finalproject.repositories.OrderItemRepository;
import com.james.demo.finalproject.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class CheckoutController {

  private final OrderRepository orderRepo;
  private final AddressRepository addressRepo;
  private final OrderItemRepository orderItemRepo;

  /**
   * CheckoutController constructor.

   */
  @Autowired
  public CheckoutController(OrderRepository orderRepo, AddressRepository addressRepo,
                                OrderItemRepository orderItemRepo) {
    this.orderRepo = orderRepo;
    this.addressRepo = addressRepo;
    this.orderItemRepo = orderItemRepo;
  }


  /**
   * Get the cart data and display it on the customerForm information page.

   */

  @RequestMapping("/checkout")
  public String viewCheckoutPage(Map<String, Object> model, HttpSession session,
                                 CustomerForm customerForm) {
    try {
      if (session.getAttribute("shoppingCart") == null) {
        throw new EmptyCartException(404, "Shopping Cart is empty");
      }
      Cart shoppingCart = (Cart) session.getAttribute("shoppingCart");
      Product item = shoppingCart.checkInvalid();
      if (item != null) {
        throw new InvalidCartItemException(
          400,
          "Shopping Cart contains an item with an invalid quantity",
          item);
      }
      model.put("cart", shoppingCart);
      return "Checkout";
    } catch (EmptyCartException | InvalidCartItemException e) {
      Application.log.info(e.getMessage() + " - Aborting checkout");
      return "redirect:/exception";
    }
  }

  /**
   * Save customerForm information page.

   */
  @PostMapping("/checkout")
  public String saveCustomerInformation(@Valid CustomerForm customerForm,
                                          BindingResult bindingResult, Map<String, Object> model,
                                            HttpSession session) {
    if (bindingResult.hasErrors()) {
      Cart shoppingCart = (Cart) session.getAttribute("shoppingCart");
      model.put("cart", shoppingCart);
      return "Checkout";
    } else {
      session.setAttribute("customerInformation", customerForm);
      return "redirect:/payment";
    }
  }

  /**
   * Get the cart and customer data and display it on the payment page.

   */
  @RequestMapping("/payment")
  public String viewPaymentPage(Map<String, Object> model, HttpSession session,
                                PaymentForm paymentForm) {

    if (session.getAttribute("shoppingCart") != null
        && session.getAttribute("customerInformation") != null) {

      Cart shoppingCart = (Cart) session.getAttribute("shoppingCart");
      CustomerForm customerForm = (CustomerForm) session.getAttribute("customerInformation");
      model.put("cart", shoppingCart);
      model.put("customerForm", customerForm);

      return "Payment";

    } else {
      return "redirect:/checkout";
    }
  }

  /**
   * Validate payment form and make payment.

   */
  @PostMapping("/payment")
  public String makePayment(@Valid PaymentForm paymentForm, BindingResult bindingResult,
                                        Map<String, Object> model, HttpSession session) {

    Cart shoppingCart = (Cart) session.getAttribute("shoppingCart");
    CustomerForm customer = (CustomerForm) session.getAttribute("customerInformation");

    if (bindingResult.hasErrors()) {

      model.put("cart", shoppingCart);
      model.put("customer", customer);
      return "Payment";

    } else {

      AddressForm address = customer.getShippingAddress();
      Address addressToSave;
      if (address.getCompany() != "") {
        addressToSave = new Address(address.getCompany(), address.getAddressLine(),
                                      address.getCity(), address.getCountry(),
                                          address.getPostcode());
      } else {
        addressToSave = new Address(address.getAddressLine(), address.getCity(),
            address.getCountry(), address.getPostcode());
      }

      Address savedAddress = addressRepo.save(addressToSave);

      Order savedOrder = orderRepo.save(new Order(UUID.randomUUID().toString(),
                              customer.getFirstName(), customer.getLastName(), customer.getEmail(),
                                customer.getPhoneNumber(), savedAddress));


      shoppingCart.getProducts().forEach((product,quantity)-> {
        OrderItem savedOrderItem = orderItemRepo.save(new OrderItem(savedOrder, product, quantity));
      } );


      session.removeAttribute("shoppingCart");
      session.removeAttribute("customerInformation");
      session.setAttribute("orderRef", savedOrder.getOrderRef());
      session.setAttribute("email", savedOrder.getEmail());

      return "redirect:/order-complete";
    }
  }

  /**
   * Get the order reference and customer data and display it on the order complete page.

   */
  @RequestMapping("/order-complete")
  public String viewOrderCompletePage(Map<String, Object> model, HttpSession session) {

    if (session.getAttribute("orderRef") != null && session.getAttribute("email") != null) {
      model.put("orderRef", session.getAttribute("orderRef"));
      model.put("email", session.getAttribute("email"));
      return "OrderComplete";
    } else {
      return "redirect:/";
    }

  }

}
