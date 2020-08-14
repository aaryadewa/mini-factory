package com.aaryadewa.dev;

import java.util.Scanner;

import com.aaryadewa.dev.controller.Dashboard;
import com.aaryadewa.dev.util.InteractiveMenuSelector;
import com.aaryadewa.dev.util.Logger;

/**
 * The entry point of Mini Factory.
 */
public final class App {
    private static final Logger logger = new Logger(App.class);

    public static void main(final String[] args) {
        final Dashboard app = new Dashboard();
        final Scanner input = new Scanner(System.in);

        app.start();

        while (app.isRunning()) {
            app.showMenu();
            logger.debug("Waiting for user input...");
            int selection = input.nextInt();
            final InteractiveMenuSelector selector = app.getMenuSelector(selection);

            if (selector == null) {
                logger.error("There is no such menu (" + selection + ")");
                continue;
            }

            // The dashboard menu has been shown before.
            final boolean dashboard = (selector instanceof Dashboard);
            if (!dashboard) {
                selector.showMenu();
            }

            selector.setScanner(input);
            selector.applySelection(selector.getSelection(selection));
        }

        input.close();
        app.stop();
    }
}
