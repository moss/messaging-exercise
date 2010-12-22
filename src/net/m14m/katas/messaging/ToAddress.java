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

    public void reportProblems(ErrorHandler handler) {
        if (!address.contains("@")) handler.error();
    }
}
