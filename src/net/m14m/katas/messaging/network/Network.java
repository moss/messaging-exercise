package net.m14m.katas.messaging.network;

import net.m14m.katas.messaging.errors.*;
import net.m14m.katas.messaging.message.Message;

import java.io.PrintWriter;

public class Network implements ErrorListener {
    private PrintWriter connection;
    private boolean disabled = false;

    public Network(PrintWriter connection) {
        this.connection = connection;
    }

    public void sendMail(Message message) {
        if (disabled) return;
        message.writeTo(connection);
    }

    public void error(ErrorMessage message) {
        disabled = true;
    }
}
