package net.m14m.katas.messaging.mailer;

import net.m14m.katas.messaging.Mailer;
import net.m14m.katas.messaging.message.*;

import java.io.PrintWriter;

public class ChatMailer implements Mailer {
    private final PrintWriter network;

    public ChatMailer(PrintWriter network) {
        this.network = network;
    }

    public void send(ToAddressBlock to, Body body) {
        network.println("connect chat");
        to.writeHeader(new ChatMessage(body, network));
        network.println("disconnect");
    }
}
