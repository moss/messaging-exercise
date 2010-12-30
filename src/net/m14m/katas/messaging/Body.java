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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Body that = (Body) o;
        return body.equals(that.body);
    }

    @Override
    public int hashCode() {
        return body.hashCode();
    }
}
