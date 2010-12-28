package net.m14m.katas.messaging.application;

import net.m14m.katas.messaging.errors.*;
import net.m14m.katas.messaging.message.*;
import net.m14m.katas.messaging.network.Sender;

import java.io.*;

public class Main {
    private static Sender sender;
    private static ErrorReporter errorReporter;

    public static void setNetwork(Writer network) {
        Main.sender = new Sender(new PrintWriter(network));
    }

    public static void setConsole(Writer console) {
        errorReporter = new ErrorReporter(console);
    }

    public static void main(String... stringArguments) {
        CommandLine commandLine = new CommandLine(stringArguments);
        ErrorBroadcaster errorBroadcaster = new ErrorBroadcaster(errorReporter, sender);
        Message message = commandLine.parseMessage();
        message.validate(errorBroadcaster);
        sender.sendMail(message);
    }
}
