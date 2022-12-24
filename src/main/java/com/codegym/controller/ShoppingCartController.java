package com.codegym.controller;

import com.codegym.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.rmi.MarshalledObject;

@Controller
@SessionAttributes("cart")
public class ShoppingCartController {
    @ModelAttribute("cart")
    public Cart setUpcart() {
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart(Cart cart) {
        ModelAndView modelAndView = new ModelAndView("cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }
}
