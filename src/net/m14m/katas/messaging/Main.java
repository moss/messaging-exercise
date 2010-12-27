package net.m14m.katas.messaging;

import java.io.Writer;

public class Main {
    private static Network network;
    private static ErrorListener listener;

    public static void setNetwork(Writer network) {
        Main.network = new Network(network);
    }

    public static void setConsole(Writer console) {
        listener = new ErrorReporter(console);
    }

    public static void main(String... args) {
        Address address = new Address(args[0]);
        Body body = new Body(args[1]);
        Message message = new Message(address, body);
        message.validate(listener);
        network.sendMail(message);
    }
}
