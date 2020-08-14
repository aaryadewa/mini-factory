package com.aaryadewa.dev;

import java.util.Scanner;

import com.aaryadewa.dev.util.Logger;

/**
 * The entry point of Mini Factory.
 */
public final class App {
    private static final Logger logger = new Logger(App.class);
    private boolean running = false;
    private final String[] menu;

    private App() {
        logger.info("*** Mini Factory ***");
        menu = new String[] {
            "(1) Adjust output verbosity",
            "(2) Exit"
        };
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

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void showMenu() {
        logger.prompt("\nPlease select a menu:");
        for (String item : menu) {
            logger.prompt(item);
        }
    }

    public static void main(String[] args) {
        App app = new App();
        Scanner input = new Scanner(System.in);

        app.start();

        while (app.isRunning()) {
            app.showMenu();
            logger.debug("Waiting for user input...");
            long selection = input.nextLong();

            if (selection == 1) {
                logger.showLevels();
                Logger.setLevel(input.nextInt());
            }

            else if (selection == 2) {
                app.setRunning(false);
            }

            else {
                logger.error("There is no such menu (" + selection + ")");
            }
        }

        input.close();
        app.stop();
    }
}
