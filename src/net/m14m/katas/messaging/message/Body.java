package net.m14m.katas.messaging.message;

import net.m14m.katas.messaging.errors.*;

public class Body {
    private final String body;

    public Body(String body) {
        this.body = body;
    }

    public void validate(ErrorListener listener) {
        if (body.isEmpty()) listener.error(new ErrorMessage("Cannot send an email with no body."));
    }

    @Override public String toString() {
        return body;
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
