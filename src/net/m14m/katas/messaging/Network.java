package net.m14m.katas.messaging;

import java.io.*;

public class Network {
    private PrintWriter connection;

    public Network(Writer connection) {
        this.connection = new PrintWriter(connection);
    }

    public void sendMail(Message message) {
        if (!message.isValid()) return;
        message.writeTo(connection);
    }
}
