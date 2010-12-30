package net.m14m.katas.messaging;

import java.io.*;
import java.util.List;

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
        PrintWriter output = new PrintWriter(network);
        List<Address> addresses = Address.listFrom(args[0]);
        Body body = new Body(args[1]);
        Sender sender = new Sender(output);
        new ValidatingSender(sender, new PrintWriter(console)).send(body, addresses);
    }
}
