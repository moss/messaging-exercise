package net.m14m.katas.messaging;

import java.io.PrintWriter;

public class Error {
    private final String message;

    public Error(String message) {
        this.message = message;
    }

    public void writeTo(PrintWriter console) {
        console.println(message);
    }
}
