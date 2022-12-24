package com.codegym.model;

import groovy.transform.Internal;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    //check item in cart
    private boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> e : products.entrySet()) {
            if (e.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    //select item in cart
    private Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> e : products.entrySet()) {
            if (e.getKey().getId().equals(product.getId())) {
                return e;
            }
        }
        return null;
    }

    //add product
    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(), newQuantity);
        }
    }

    //remove product form list
    public void removeProductFormList(Product product) {
        if (checkItemInCart(product)) {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            products.remove(itemEntry.getKey());
        }
    }

    //decrease product
    public void decreaseProduct(Product product) {
        if (checkItemInCart(product)) {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            if (itemEntry.getValue() > 0) {
                Integer newQuantity = itemEntry.getValue() - 1;
                products.replace(itemEntry.getKey(), newQuantity);
            }
        }
    }

    //count product quantity
    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> e : products.entrySet()) {
            productQuantity += e.getValue();
        }
        return productQuantity;
    }

    // count item quantity
    public Integer countItemQuantity() {
        return products.size();
    }

    // count total payment
    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<Product, Integer> e : products.entrySet()) {
            payment += e.getKey().getPrice() * (float) e.getValue();
        }
        return payment;
    }
}