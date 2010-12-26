package net.m14m.katas.messaging.mailer;

import net.m14m.katas.messaging.Mailer;
import net.m14m.katas.messaging.message.*;

import java.io.PrintWriter;

public class SmtpMailer implements Mailer {
    private PrintWriter network;
    private SmtpToAddressFormatter toAddressFormatter;

    public SmtpMailer(PrintWriter network) {
        this.network = network;
        toAddressFormatter = new SmtpToAddressFormatter(network);
    }

    public void send(ToAddressBlock to, Body body) {
        network.println("connect smtp");
        to.writeHeader(toAddressFormatter);
        network.println();
        body.writeTo(network);
        network.println();
        network.println();
        network.println("disconnect");
    }
}
