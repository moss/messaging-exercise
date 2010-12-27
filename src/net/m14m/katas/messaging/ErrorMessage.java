package net.m14m.katas.messaging;

public class ErrorMessage {
    private final String message;

    public ErrorMessage(String message) {
        this.message = message;
    }

    public static ErrorMessage withCause(String message, Object cause) {
        return new ErrorMessage(message + ": " + cause);
    }

    @Override public String toString() {
        return message;
    }
}
