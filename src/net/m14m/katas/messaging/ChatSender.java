package net.m14m.katas.messaging;

import java.io.PrintWriter;
import java.util.List;

public class ChatSender implements Sender {
    private final PrintWriter output;

    public ChatSender(PrintWriter output) {
        this.output = output;
    }

    public void send(List<Address> addresses, Body body) {
        output.println("connect chat");
        for (Address address : addresses) {
            sendMessage(address, body);
        }
        output.println("disconnect");
    }

    private void sendMessage(Address address, Body body) {
        output.println("<" + address + ">(" + escapeParentheses(body) + ")");
    }

    private String escapeParentheses(Body body) {
        return body.toString().replace(")", "\\)");
    }
}
