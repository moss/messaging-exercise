package net.m14m.katas.messaging;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;

public class SmtpMailerTest {
    private StringWriter network;
    private SmtpMailer mailer;

    @Before public void setUp() throws Exception {
        network = new StringWriter();
        mailer = new SmtpMailer(new PrintWriter(network));
    }

    @Test public void sendsTheEmailOutToTheNetwork() {
        mailer.send(new ToAddress("joe@example.com"), new Body("Hi there!"));
        assertEquals("connect smtp\n" +
                "To: joe@example.com\n" +
                "\n" +
                "Hi there!\n" +
                "\n" +
                "disconnect\n", network.toString());
    }
}
