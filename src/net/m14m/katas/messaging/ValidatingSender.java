package net.m14m.katas.messaging;

import java.io.PrintWriter;
import java.util.List;

class ValidatingSender {
    private Sender sender;
    private final PrintWriter console;

    public ValidatingSender(Sender sender, PrintWriter console) {
        this.sender = sender;
        this.console = console;
    }

    public void send(Body body, List<Address> addresses) {
        for (Address address : addresses) {
            if (!address.isValid()) {
                console.println("Invalid email address: " + address);
                return;
            }
        }
        if (body.isEmpty()) {
            console.println("Cannot send an email with no body.");
            return;
        }
        sender.send(addresses, body);
    }
}
