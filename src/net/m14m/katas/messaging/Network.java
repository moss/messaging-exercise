package net.m14m.katas.messaging;

import java.io.*;

public class Network {
    private PrintWriter connection;

    public Network(Writer connection) {
        this.connection = new PrintWriter(connection);
    }

    public void sendMail(Address address, Body body) {
        if (!address.isValid()) return;
        connection.println("connect smtp");
        connection.println("To: " + address);
        connection.println();
        connection.println(body);
        connection.println();
        connection.println("disconnect");
    }
}
