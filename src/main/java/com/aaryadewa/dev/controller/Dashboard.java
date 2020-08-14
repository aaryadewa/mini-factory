package com.aaryadewa.dev.controller;

import java.util.HashMap;
import java.util.Map;

import com.aaryadewa.dev.repository.Warehouse;
import com.aaryadewa.dev.util.InteractiveMenuSelector;
import com.aaryadewa.dev.util.Logger;

public class Dashboard extends InteractiveMenuSelector {
  private static final Logger logger = new Logger(Dashboard.class);
  private boolean running = false;
  private final String[] menu;
  private final Map<Integer, InteractiveMenuSelector> menuSelectors;
  private final Warehouse warehouse = new Warehouse();

  public Dashboard() {
    logger.info("*** Mini Factory ***");

    menu = new String[] { "(1) Manage Products", "(2) Adjust output verbosity", "(3) Exit" };

    menuSelectors = new HashMap<>();
    menuSelectors.put(1, new ProductionMachine(warehouse));
    menuSelectors.put(2, logger);
    menuSelectors.put(3, this);
  }

  public void start() {
    logger.info("Starting up the application...");
    running = true;
  }

  public void stop() {
    logger.info("Stopping the application...");
  }

  public boolean isRunning() {
    return running;
  }

  public void setRunning(final boolean running) {
    this.running = running;
  }

  public InteractiveMenuSelector getMenuSelector(int number) {
    return menuSelectors.get(number);
  }

  @Override
  public void showMenu() {
    logger.prompt("\nPlease select a menu:");
    for (final String item : menu) {
      logger.prompt(item);
    }
  }

  @Override
  public Object getSelection(Object defaultSelection) {
    return defaultSelection;
  }

  @Override
  public void applySelection(Object selection) {
    setRunning(false);
  }

}