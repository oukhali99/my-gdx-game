package com.mygdx.game.utils;

import java.util.Date;

public class Logger {
    private static Logger instance;

    private static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }

        return instance;
    }

    public static void log(String message) {
        System.out.println(new Date() + " - " + message);
    }
}
