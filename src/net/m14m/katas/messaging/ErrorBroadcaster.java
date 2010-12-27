package net.m14m.katas.messaging;

public class ErrorBroadcaster implements ErrorListener {
    private final ErrorListener[] listeners;

    public ErrorBroadcaster(ErrorListener... listeners) {
        this.listeners = listeners;
    }

    public void error(ErrorMessage message) {
        for (ErrorListener listener : listeners) {
            listener.error(message);
        }
    }
}
