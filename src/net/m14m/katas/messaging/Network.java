package net.m14m.katas.messaging;

import java.io.*;

public class Network {
    private PrintWriter connection;

    public Network(Writer connection) {
        this.connection = new PrintWriter(connection);
    }

    public void sendMail() {
        connection.println("connect smtp");
        connection.println("To: joe@example.com");
        connection.println();
        connection.println("Hi there!");
        connection.println();
        connection.println("disconnect");
    }
}
