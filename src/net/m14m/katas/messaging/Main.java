package net.m14m.katas.messaging;

import java.io.*;

public class Main {
    private static PrintWriter network;
    private static Writer console;

    public static void setNetwork(Writer network) {
        Main.network = new PrintWriter(network);
    }

    public static void setConsole(Writer console) {
        Main.console = console;
    }

    public static void main(String... args) {
        String to = args[0];
        String body = args[1];
        network.println("connect smtp");
        network.println("To: " + to);
        network.println();
        network.println(body);
        network.println();
        network.println("disconnect");
    }
}
