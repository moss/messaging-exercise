package net.m14m.katas.messaging.mailer;

import net.m14m.katas.messaging.*;
import net.m14m.katas.messaging.message.*;

import java.io.PrintWriter;

public class ChatMailer implements Mailer, ToAddressFormatter {
    private final PrintWriter network;

    public ChatMailer(PrintWriter network) {
        this.network = network;
    }

    public void send(ToAddressBlock to, Body body) {
        network.println("connect chat");
        network.print("<");
        to.writeHeader(this);
        network.print(">");
        network.print("(");
        body.writeTo(network);
        network.println(")");
        network.println("disconnect");
    }

    public void append(IndividualToAddress address) {
        address.appendTo(network);
    }
}
