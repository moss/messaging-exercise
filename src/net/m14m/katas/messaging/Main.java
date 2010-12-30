package net.m14m.katas.messaging;

import java.io.*;

public class Main {
    private static Writer network;
    private static Writer console;

    public static void setNetwork(Writer network) {
        Main.network = network;
    }

    public static void setConsole(Writer console) {
        Main.console = console;
    }

    public static void main(String... args) {
        Address address = new Address(args[0]);
        if (!address.isValid()) return;
        PrintWriter output = new PrintWriter(network);
        new Sender(output).send(address, args[1]);
    }
}
