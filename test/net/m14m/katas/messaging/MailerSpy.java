package net.m14m.katas.messaging;

import static org.junit.Assert.*;

class MailerSpy implements Mailer {
    private boolean sent = false;

    public void send(ToAddress to, Body body) {
        sent = true;
    }

    public void shouldHaveSent() {
        assertTrue(sent);
    }

    public void shouldNotHaveSent() {
        assertFalse(sent);
    }
}
