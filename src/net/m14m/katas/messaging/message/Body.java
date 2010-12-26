package net.m14m.katas.messaging.message;

import net.m14m.katas.messaging.*;

import java.io.PrintWriter;

public class Body {
    private final String body;

    public Body(String body) {
        this.body = body;
    }

    public void writeTo(PrintWriter network) {
        network.print(body);
    }

    public void reportProblems(ErrorHandler handler) {
        if (body.isEmpty())
            handler.error(new ValidationError("Cannot send an email with no body."));
    }
}
