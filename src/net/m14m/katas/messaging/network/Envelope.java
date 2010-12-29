package net.m14m.katas.messaging.network;

import net.m14m.katas.messaging.message.*;

import java.io.PrintWriter;

public class Envelope {
    private Message message;
    private Format format;

    public Envelope(Message message) {
        this.message = message;
        format = new MailFormat();
    }

    public void send(PrintWriter connection) {
        connection.println("connect smtp");
        connection.println(message.format(format));
        connection.println("disconnect");
    }
}
