package net.m14m.katas.messaging.mailer;

import net.m14m.katas.messaging.message.Message;

import java.io.PrintWriter;

public class Environment {
    private final PrintWriter network;
    private final PrintWriter console;

    public Environment(PrintWriter network, PrintWriter console) {
        this.network = network;
        this.console = console;
    }

    public void send(Message message) {
        SmtpMailer mailer = new SmtpMailer(network);
        ValidatingMailer validatingMailer = new ValidatingMailer(mailer, console);
        message.sendThrough(validatingMailer);
    }
}