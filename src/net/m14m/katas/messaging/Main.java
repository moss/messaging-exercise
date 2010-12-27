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
        network.println("connect smtp");
        network.println("To: joe@example.com");
        network.println();
        network.println("Hi there!");
        network.println();
        network.println("disconnect");
    }
}
