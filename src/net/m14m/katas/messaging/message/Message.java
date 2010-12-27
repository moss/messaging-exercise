package net.m14m.katas.messaging.message;

import net.m14m.katas.messaging.errors.ErrorListener;

import java.io.PrintWriter;

public class Message {
    private final AddressList addressList;
    private final Body body;

    public Message(AddressList addressList, Body body) {
        this.addressList = addressList;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return addressList.equals(message.addressList) && body.equals(message.body);
    }

    @Override
    public int hashCode() {
        int result = addressList.hashCode();
        result = 31 * result + body.hashCode();
        return result;
    }
}
