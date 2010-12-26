package net.m14m.katas.messaging;

import java.io.PrintWriter;

public class ValidationError {
    private final String message;

    public ValidationError(String message) {
        this.message = message;
    }

    public void writeTo(PrintWriter console) {
        console.println(message);
    }
}
