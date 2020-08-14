package com.aaryadewa.dev.controller;

import com.aaryadewa.dev.entity.Product;
import com.aaryadewa.dev.repository.Warehouse;
import com.aaryadewa.dev.util.InteractiveMenuSelector;
import com.aaryadewa.dev.util.Logger;

public class ProductionMachine extends InteractiveMenuSelector {
  private static final Logger logger = new Logger(ProductionMachine.class);
  private final String[] menu;
  private final Warehouse warehouse;

  public ProductionMachine(Warehouse warehouse) {
    this.warehouse = warehouse;
    menu = new String[] { "(1) List product", "(2) Add product", "(3) Back" };
  }

  @Override
  public void showMenu() {
    for (final String item : menu) {
      logger.prompt(item);
    }
  }

  @Override
  public Object getSelection(Object defaultSelection) {
    return scanner.nextInt();
  }

  @Override
  public void applySelection(Object selection) {
    int value = (int) selection;

    if (value == 1) {
      if (warehouse.getProducts().isEmpty()) {
        logger.info("There is no products yet.");
        return;
      }

      logger.info("List of all products in the warehouse");
      for (Product product : warehouse.getProducts()) {
        logger.info(">>> " + product);
      }
    }

    else if (value == 2) {
      Product product = new Product();

      logger.prompt("Please enter product name");
      product.setName(scanner.next());

      logger.prompt("Please enter product description");
      product.setDescription(scanner.next());
      warehouse.addProduct(product);
      scanner.nextLine();
    }
  }

}