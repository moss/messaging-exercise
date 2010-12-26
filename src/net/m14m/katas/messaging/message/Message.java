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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return body.equals(message.body) && to.equals(message.to);
    }

    @Override
    public int hashCode() {
        int result = to.hashCode();
        result = 31 * result + body.hashCode();
        return result;
    }
}
