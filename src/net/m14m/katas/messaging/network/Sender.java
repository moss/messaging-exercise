package net.m14m.katas.messaging.network;

import net.m14m.katas.messaging.errors.*;
import net.m14m.katas.messaging.message.Message;

import java.io.PrintWriter;

public class Sender implements ErrorListener {
    private PrintWriter connection;
    private boolean disabled = false;

    public Sender(PrintWriter connection) {
        this.connection = connection;
    }

    public void sendMail(Message message) {
        if (disabled) return;
        connection.println("connect smtp");
        MailFormatter formatter = new MailFormatter();
        connection.println(message.format(formatter));
        connection.println("disconnect");
    }

    public void error(ErrorMessage message) {
        disabled = true;
    }
}
