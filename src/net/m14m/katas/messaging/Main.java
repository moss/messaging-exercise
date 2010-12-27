package net.m14m.katas.messaging;

import java.io.*;

public class Main {
    private static Network network;
    private static PrintWriter console;

    public static void setNetwork(Writer network) {
        Main.network = new Network(network);
    }

    public static void setConsole(Writer console) {
        Main.console = new PrintWriter(console);
    }

    public static void main(String... args) {
        Address address = new Address(args[0]);
        Body body = new Body(args[1]);
        if (!address.isValid()) {
            console.println("Invalid email address: " + address);
        }
        network.sendMail(address, body);
    }
}
