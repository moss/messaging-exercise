package net.m14m.katas.messaging.application;

import net.m14m.katas.messaging.mailer.*;

import java.io.*;

import static net.m14m.katas.messaging.mailer.Format.*;

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
        Environment environment = new Environment();
        environment.registerMailer(smtp, new ValidatingMailer(new SmtpMailer(network), console));
        environment.registerMailer(chat, new ValidatingMailer(new ChatMailer(network), console));
        new Command(args).runIn(environment);
        reportConnectionProblems();
    }

    private static void reportConnectionProblems() {
        if (network.checkError()) console.println("Connection error. Please try again.");
    }
}
