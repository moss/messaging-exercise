package net.m14m.katas.messaging;

import org.junit.*;

import java.io.*;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class SenderTest {
    private StringWriter output = new StringWriter();
    private Sender sender = new Sender(new PrintWriter(output));

    @Test public void sendToMultipleAddresses() {
        sender.send(asList(new Address("a@example.com"), new Address("b@example.com")),
                new Body("Hello"));
        assertEquals("connect smtp\n" +
                "To: a@example.com\n" +
                "To: b@example.com\n" +
                "\n" +
                "Hello\n" +
                "\n" +
                "disconnect\n", output.toString());
    }
}
