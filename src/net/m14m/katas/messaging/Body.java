package net.m14m.katas.messaging;

public class Body {
    private final String body;

    public Body(String body) {
        this.body = body;
    }

    @Override public String toString() {
        return body;
    }

    public boolean isEmpty() {
        return body.isEmpty();
    }
}
