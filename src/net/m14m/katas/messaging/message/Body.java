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
}
