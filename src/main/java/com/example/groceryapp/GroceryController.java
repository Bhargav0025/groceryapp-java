package com.example.groceryapp.controller;

import com.example.groceryapp.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GroceryController {
    @Autowired
    private GroceryService groceryService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", groceryService.getProducts());
        return "index";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam int id, @RequestParam int quantity) {
        groceryService.addToCart(id, quantity);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", groceryService.getCart());
        model.addAttribute("total", groceryService.getCartTotal());
        return "cart";
    }

    @PostMapping("/checkout")
    public String checkout(Model model) {
        groceryService.clearCart();
        model.addAttribute("message", "Thank you for your purchase!");
        return "checkout";
    }
}
