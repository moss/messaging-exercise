package net.m14m.katas.messaging;

public class Application {
    private Mailer mailer;

    public Application(Mailer mailer) {
        this.mailer = mailer;
    }

    public void send(Email email) {
        email.send(mailer);
    }
}
