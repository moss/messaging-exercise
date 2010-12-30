package net.m14m.katas.messaging.network;

import net.m14m.katas.messaging.message.*;

import java.io.PrintWriter;

public class Envelope {
    private Message message;
    private Format format;

    public Envelope(Message message, Format format) {
        this.message = message;
        this.format = format;
    }

    public void send(PrintWriter connection) {
        connection.println("connect smtp");
        connection.println(message.format(format));
        connection.println("disconnect");
    }
}
