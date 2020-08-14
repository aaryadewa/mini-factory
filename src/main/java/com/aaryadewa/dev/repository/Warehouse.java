package com.aaryadewa.dev.repository;

import java.util.ArrayList;
import java.util.List;

import com.aaryadewa.dev.entity.Product;

public class Warehouse {
  private List<Product> products = new ArrayList<>();

  public List<Product> getProducts() {
    return products;
  }

  public boolean addProduct(Product product) {
    return products.add(product);
  }
}