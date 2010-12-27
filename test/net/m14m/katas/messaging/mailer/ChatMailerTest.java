package net.m14m.katas.messaging.mailer;

import net.m14m.katas.messaging.message.*;
import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;

public class ChatMailerTest {
    private StringWriter network;
    private ChatMailer mailer;

    @Before public void setUp() throws Exception {
        network = new StringWriter();
        mailer = new ChatMailer(new PrintWriter(network));
    }

    @Test public void sendsTheEmailOutToTheNetwork() {
        mailer.send(ToAddressBlock.parseCommaSeparated("joe@example.com"), new Body("Hi there!"));
        assertEquals("connect chat\n" +
                "<joe@example.com>(Hi there!)\n" +
                "disconnect\n", network.toString());
    }

    @Test public void escapesClosingParentheses() {
        mailer.send(ToAddressBlock.parseCommaSeparated("joe@example.com"), new Body(")"));
        assertEquals("connect chat\n" +
                "<joe@example.com>(\\))\n" +
                "disconnect\n", network.toString());
    }
}
