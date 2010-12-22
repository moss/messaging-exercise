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
        ToAddress to = new ToAddress(args[0]);
        Body body = new Body(args[1]);
        Email email = new Email(to, body);
        new Application(new Mailer(network)).send(email);
    }
}
