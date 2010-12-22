package net.m14m.katas.messaging;

import java.io.PrintWriter;

public class ToAddress {
    private final String address;

    public ToAddress(String address) {
        this.address = address;
    }

    public void writeHeader(PrintWriter network) {
        network.println("To: " + address);
    }

    public void send(Body body, PrintWriter network) {
        if (!address.contains("@")) return;
        network.println("connect smtp");
        writeHeader(network);
        network.println();
        body.writeTo(network);
        network.println();
        network.println("disconnect");
    }
}
