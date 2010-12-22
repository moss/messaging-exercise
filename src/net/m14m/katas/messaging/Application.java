package net.m14m.katas.messaging;

import java.io.PrintWriter;

public class Application {
    private final PrintWriter network;

    public Application(PrintWriter network) {
        this.network = network;
    }

    public void sendEmail(ToAddress to, Body body) {
        new Email(to, body).send(network);
    }
}
