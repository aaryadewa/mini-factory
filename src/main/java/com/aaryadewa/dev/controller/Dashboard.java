package com.aaryadewa.dev.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.aaryadewa.dev.util.InteractiveMenuSelector;
import com.aaryadewa.dev.util.Logger;

public class Dashboard implements InteractiveMenuSelector {
  private static final Logger logger = new Logger(Dashboard.class);
  private boolean running = false;
  private final String[] menu;
  private final Map<Integer, InteractiveMenuSelector> menuSelectors;

  public Dashboard() {
    logger.info("*** Mini Factory ***");

    menu = new String[] { "(1) Adjust output verbosity", "(2) Exit" };

    menuSelectors = new HashMap<>();
    menuSelectors.put(1, logger);
    menuSelectors.put(2, this);
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
  public Object getSelection(Scanner scanner, Object defaultSelection) {
    return defaultSelection;
  }

  @Override
  public void applySelection(Object selection) {
    setRunning(false);
  }

}