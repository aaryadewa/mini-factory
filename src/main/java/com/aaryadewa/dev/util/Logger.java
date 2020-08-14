package com.aaryadewa.dev.util;

public class Logger {
  private final Class<? extends Object> clazz;

  public Logger(Class<? extends Object> clazz) {
    this.clazz = clazz;
  }

  public void info(String message) {
    System.out.println(clazz + " - " + message);
  }
}