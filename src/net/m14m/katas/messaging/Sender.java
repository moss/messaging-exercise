package net.m14m.katas.messaging;

import java.io.PrintWriter;

class Sender {
    private PrintWriter output;

    public Sender(PrintWriter output) {
        this.output = output;
    }

    public void send(Address address, String body) {
        output.println("connect smtp");
        output.println("To: " + address);
        output.println();
        output.println(body);
        output.println();
        output.println("disconnect");
    }
}
