package net.m14m.katas.messaging.application;

import net.m14m.katas.messaging.mailer.Environment;

import java.io.*;

public class Main {
    private static PrintWriter network;
    private static PrintWriter console;

    public static void setNetwork(Writer network) {
        Main.network = new PrintWriter(network);
    }

    public static void setConsole(Writer console) {
        Main.console = new PrintWriter(console);
    }

    public static void main(String... args) {
        Environment environment = new Environment(network, console);
        new Command(args).runIn(environment);
    }
}
