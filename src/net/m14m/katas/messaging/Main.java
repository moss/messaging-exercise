package net.m14m.katas.messaging;

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
        ToAddressBlock to = ToAddressBlock.parseCommaSeparated(args[0]);
        Body body = new Body(args[1]);
        SmtpMailer mailer = new SmtpMailer(network);
        ValidatingMailer validatingMailer = new ValidatingMailer(mailer, console);
        validatingMailer.send(to, body);
    }
}
