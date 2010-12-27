package net.m14m.katas.messaging;

import java.io.PrintWriter;

public class Message {
    private final Address address;
    private final Body body;

    public Message(Address address, Body body) {
        this.address = address;
        this.body = body;
    }

    public void validate(ErrorListener listener) {
        address.validate(listener);
        body.validate(listener);
    }

    public void writeTo(PrintWriter connection) {
        connection.println("connect smtp");
        connection.println(new HeaderBlock(address));
        connection.println();
        connection.println(body);
        connection.println();
        connection.println("disconnect");
    }

    private static class HeaderBlock {
        private Address address;

        public HeaderBlock(Address address) {
            this.address = address;
        }

        @Override public String toString() {
            return "To: " + address;
        }
    }
}
