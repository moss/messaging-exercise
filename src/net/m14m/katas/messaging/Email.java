package net.m14m.katas.messaging;

import java.io.PrintWriter;

public class Email {
    private ToAddress to;
    private Body body;

    public Email(ToAddress to, Body body) {
        this.to = to;
        this.body = body;
    }

    public void send(PrintWriter network) {
        to.send(body, network);
    }
}
