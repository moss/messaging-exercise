package net.m14m.katas.messaging;

import java.io.PrintWriter;
import java.util.List;

class Sender {
    private PrintWriter output;

    public Sender(PrintWriter output) {
        this.output = output;
    }

    public void send(List<Address> addresses, Body body) {
        output.println("connect smtp");
        for (Address address : addresses) {
            output.println("To: " + address);
        }
        output.println();
        output.println(body);
        output.println();
        output.println("disconnect");
    }
}
