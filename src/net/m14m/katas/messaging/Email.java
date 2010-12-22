package net.m14m.katas.messaging;

public class Email {
    private ToAddress to;
    private Body body;

    public Email(ToAddress to, Body body) {
        this.to = to;
        this.body = body;
    }

    public void send(Mailer mailer) {
        if (!to.isValid()) return;
        mailer.send(to, body);
    }
}
