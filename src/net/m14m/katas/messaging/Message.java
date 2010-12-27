package net.m14m.katas.messaging;

import java.io.PrintWriter;

public class Message {
    private final AddressList addressList;
    private final Body body;

    public Message(Address address, Body body) {
        addressList = new AddressList(address);
        this.body = body;
    }

    public void validate(ErrorListener listener) {
        addressList.validate(listener);
        body.validate(listener);
    }

    public void writeTo(PrintWriter connection) {
        connection.println("connect smtp");
        connection.print(addressList);
        connection.println();
        connection.println(body);
        connection.println();
        connection.println("disconnect");
    }
}
