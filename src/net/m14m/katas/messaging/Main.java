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
        CommandLine commandLine = new CommandLine(args);
        List<Address> addresses = commandLine.getAddresses();
        Body body = commandLine.getBody();
        Sender sender = commandLine.createSender(output);
        new ValidatingSender(sender, new PrintWriter(console)).send(body, addresses);
    }
}
