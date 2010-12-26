package net.m14m.katas.messaging.message;

import net.m14m.katas.messaging.ErrorHandler;

import java.io.PrintWriter;

public class Body {
    private final String body;

    public Body(String body) {
        this.body = body;
    }

    public void writeTo(PrintWriter network) {
        network.println(body);
    }

    public void reportProblems(ErrorHandler handler) {
        if (body.isEmpty())
            handler.error(new net.m14m.katas.messaging.Error("Cannot send an email with no body."));
    }
}
