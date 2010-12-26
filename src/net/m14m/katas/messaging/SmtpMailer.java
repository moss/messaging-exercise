package net.m14m.katas.messaging;

import java.io.PrintWriter;

public class SmtpMailer implements Mailer {
    private PrintWriter network;

    public SmtpMailer(PrintWriter network) {
        this.network = network;
    }

    public void send(ToAddressBlock to, Body body) {
        network.println("connect smtp");
        to.writeHeader(network);
        network.println();
        body.writeTo(network);
        network.println();
        network.println("disconnect");
    }
}
