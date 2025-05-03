package com.example.groceryapp.service;

import com.example.groceryapp.model.Product;
import com.example.groceryapp.model.CartItem;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class GroceryService {
    private final List<Product> products = new ArrayList<>();
    private final List<CartItem> cart = new ArrayList<>();

    public GroceryService() {
        products.add(new Product(1, "Apples", 2.5));
        products.add(new Product(2, "Bread", 1.2));
        products.add(new Product(3, "Milk", 1.5));
    }

    // Methods: getProducts(), addToCart(), getCart(), getTotal(), clearCart()
}
