package net.m14m.katas.messaging;

import java.io.Writer;

public class Main {
    private static Network network;
    private static Writer console;

    public static void setNetwork(Writer network) {
        Main.network = new Network(network);
    }

    public static void setConsole(Writer console) {
        Main.console = console;
    }

    public static void main(String... args) {
        network.sendMail();
    }
}
