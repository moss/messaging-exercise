package net.m14m.katas.messaging;

import java.io.PrintWriter;

public class Mailer {
    private PrintWriter network;

    public Mailer(PrintWriter network) {
        this.network = network;
    }

    public void send(ToAddress to, Body body) {
        network.println("connect smtp");
        to.writeHeader(network);
        network.println();
        body.writeTo(network);
        network.println();
        network.println("disconnect");
    }
}
