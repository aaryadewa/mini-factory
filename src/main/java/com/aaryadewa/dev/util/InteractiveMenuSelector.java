package com.aaryadewa.dev.util;

import java.util.Scanner;

public interface InteractiveMenuSelector {

  /**
   * Should show the menu.
   */
  void showMenu();

  /**
   * Get the selection from the scanner or the specified value.
   * @param scanner The scanner can be used to catch the new input token.
   * @param defaultSelection Use this value as the default value.
   */
  Object getSelection(Scanner scanner, Object defaultSelection);

  /**
   * Apply the user selection.
   */
  void applySelection(Object selection);

}