package net.m14m.katas.messaging;

import java.io.Writer;

public class Main {
    private static Network network;
    private static ErrorReporter errorReporter;

    public static void setNetwork(Writer network) {
        Main.network = new Network(network);
    }

    public static void setConsole(Writer console) {
        errorReporter = new ErrorReporter(console);
    }

    public static void main(String... stringArguments) {
        Arguments arguments = new Arguments(stringArguments);
        ErrorBroadcaster errorBroadcaster = new ErrorBroadcaster(errorReporter, network);
        Message message = arguments.createMessage();
        message.validate(errorBroadcaster);
        network.sendMail(message);
    }
}
