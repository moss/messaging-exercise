package net.m14m.katas.messaging;

import java.io.*;

public class ErrorReporter implements ErrorListener {
    private final PrintWriter console;

    public ErrorReporter(Writer console) {
        this.console = new PrintWriter(console);
    }

    public void error(ErrorMessage message) {
        console.println(message);
    }
}
