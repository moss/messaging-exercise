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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ValidationError that = (ValidationError) o;
        return message.equals(that.message);
    }

    @Override
    public int hashCode() {
        return message.hashCode();
    }
}
