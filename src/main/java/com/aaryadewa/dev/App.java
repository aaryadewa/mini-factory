package com.aaryadewa.dev;

import com.aaryadewa.dev.util.Logger;

/**
 * The entry point of Mini Factory.
 */
public final class App {
    private static final Logger logger = new Logger(App.class);

    private App() {
        logger.info("*** Mini Factory ***");
    }

    public void start() {
        logger.info("Starting up the application...");
    }

    public void stop() {
        logger.info("Stopping the application...");
    }

    public static void main(String[] args) {
        App app = new App();
        app.start();
        app.stop();
    }
}
