package net.m14m.katas.messaging.network;

import net.m14m.katas.messaging.errors.*;

import java.io.PrintWriter;

public class Sender implements ErrorListener {
    private PrintWriter connection;
    private boolean disabled = false;

    public Sender(PrintWriter connection) {
        this.connection = connection;
    }

    public void error(ErrorMessage message) {
        disabled = true;
    }

    public void sendMail(Envelope envelope) {
        if (disabled) return;
        envelope.send(connection);
    }

    public void validate(ErrorListener listener) {
        if (connection.checkError()) {
            listener.error(new ErrorMessage("Connection error. Please try again."));
        }
    }
}
