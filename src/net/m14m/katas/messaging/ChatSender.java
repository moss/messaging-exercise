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
        output.println("<" + addresses.get(0) + ">(" + escapeParentheses(body) + ")");
        output.println("disconnect");
    }

    private String escapeParentheses(Body body) {
        return body.toString().replace(")", "\\)");
    }
}
