package net.m14m.katas.messaging;

import java.io.PrintWriter;

public class Body {
    private final String body;

    public Body(String body) {
        this.body = body;
    }

    public void writeTo(PrintWriter network) {
        network.println(body);
    }
}
