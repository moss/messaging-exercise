package net.m14m.katas.messaging.mailer;

import net.m14m.katas.messaging.ToAddressFormatter;
import net.m14m.katas.messaging.message.*;

import java.io.PrintWriter;

public class ChatMessage implements ToAddressFormatter {
    private final Body body;
    private final PrintWriter network;

    public ChatMessage(Body body, PrintWriter network) {
        this.body = body;
        this.network = network;
    }

    public void append(IndividualToAddress address) {
        network.print("<");
        address.appendTo(network);
        network.print(">");
        network.print("(");
        body.writeEscapingParentheses(network);
        network.println(")");
    }
}
