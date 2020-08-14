package com.aaryadewa.dev.util;

import java.util.Scanner;

public abstract class InteractiveMenuSelector {

  protected Scanner scanner;

  public void setScanner(Scanner scanner) {
    if (this.scanner == null)
      this.scanner = scanner;
  }

  /**
   * Should show the menu.
   */
  public abstract void showMenu();

  /**
   * Get the selection from the scanner or the specified value.
   * 
   * @param scanner          The scanner can be used to catch the new input token.
   * @param defaultSelection Use this value as the default value.
   */
  public abstract Object getSelection(Object defaultSelection);

  /**
   * Apply the user selection.
   */
  public abstract void applySelection(Object selection);

}