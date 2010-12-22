package net.m14m.katas.messaging;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;

public class EmailTest {
    private StringWriter network = new StringWriter();

    @Test public void shouldNotSendAnythingIfToAddressIsInvalid() {
        Email email = new Email(new ToAddress("invalid"), new Body("whatever"));
        email.send(new PrintWriter(network));
        assertEquals("", network.toString());
    }
}
