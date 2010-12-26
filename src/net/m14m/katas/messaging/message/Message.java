package net.m14m.katas.messaging.message;

import net.m14m.katas.messaging.Mailer;

public class Message {
    private final ToAddressBlock to;
    private final Body body;

    public Message(ToAddressBlock to, Body body) {
        this.to = to;
        this.body = body;
    }

    public void sendThrough(Mailer mailer) {
        mailer.send(to, body);
    }
}
