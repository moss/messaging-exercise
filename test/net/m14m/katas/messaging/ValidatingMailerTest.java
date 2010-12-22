package net.m14m.katas.messaging;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;

public class ValidatingMailerTest {
    private MailerSpy mailer = new MailerSpy();
    private StringWriter console = new StringWriter();
    private ValidatingMailer validatingMailer;

    @Before public void setUp() throws Exception {
        validatingMailer = new ValidatingMailer(mailer, new PrintWriter(console));
    }

    @Test public void shouldSendIfValid() {
        validatingMailer.send(new ToAddress("joe@example.com"), new Body("Hi there!"));
        mailer.shouldHaveSent();
    }

    @Test public void shouldNotSendIfInvalid() {
        validatingMailer.send(new ToAddress("not valid"), new Body("Hi there!"));
        mailer.shouldNotHaveSent();
    }

    @Test public void reportsErrors() {
        validatingMailer.error();
        assertEquals("Invalid email address: no at sign\n", console.toString());
    }
}
