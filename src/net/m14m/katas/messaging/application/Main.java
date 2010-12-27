package net.m14m.katas.messaging.application;

import net.m14m.katas.messaging.errors.*;
import net.m14m.katas.messaging.message.*;
import net.m14m.katas.messaging.network.Network;

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
        CommandLine commandLine = new CommandLine(stringArguments);
        ErrorBroadcaster errorBroadcaster = new ErrorBroadcaster(errorReporter, network);
        Message message = commandLine.parseMessage();
        message.validate(errorBroadcaster);
        network.sendMail(message);
    }
}
