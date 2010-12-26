package net.m14m.katas.messaging;

import java.io.PrintWriter;

public class Environment {
    private final PrintWriter network;
    private final PrintWriter console;

    public Environment(PrintWriter network, PrintWriter console) {
        this.network = network;
        this.console = console;
    }

    public void send(ToAddressBlock to, Body body) {
        SmtpMailer mailer = new SmtpMailer(network);
        ValidatingMailer validatingMailer = new ValidatingMailer(mailer, console);
        validatingMailer.send(to, body);
    }
}
