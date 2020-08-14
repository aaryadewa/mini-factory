package com.aaryadewa.dev.util;

public class Logger {
  private final Class<? extends Object> clazz;

  private static final int DEBUG = 4;
  private static final int INFO = 3;
  private static final int WARN = 2;
  private static final int ERROR = 1;

  private static final String[] LEVEL_OPTIONS = new String[] {
    "(" + DEBUG + ") Show all messages",
    "(" + INFO + ") Don't show debug messages",
    "(" + WARN + ") Show warning and error messages only",
    "(" + ERROR + ") I don't care all but error messages"
  };

  private static int level = DEBUG;

  public Logger(Class<? extends Object> clazz) {
    this.clazz = clazz;
  }

  public void debug(String message) {
    if (level >= DEBUG)
      println("[DEBUG] " + clazz.getName() + " - " + message);
  }

  public void info(String message) {
    if (level >= INFO)
      println("[INFO] " + clazz.getName() + " - " + message);
  }

  public void warn(String message) {
    if (level >= WARN)
      println("[WARN] " + clazz.getName() + " - " + message);
  }

  public void error(String message) {
    if (level >= ERROR)
      println("[ERROR] " + clazz.getName() + " - " + message);
  }

  public void prompt(String message) {
    println(message);
  }

  public void showLevels() {
    for (String option : LEVEL_OPTIONS) {
      prompt(option);
    }
  }

  public static void setLevel(int level) {
    if (level > DEBUG) {
      level = DEBUG;
    } else if (level < ERROR) {
      level = ERROR;
    }
    Logger.level = level;
  }

  private void println(String message) {
    System.out.println(message);
  }
}