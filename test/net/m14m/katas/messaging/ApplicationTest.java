package net.m14m.katas.messaging;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;

public class ApplicationTest {
    private StringWriter network;
    private Application application;

    @Before public void setUp() throws Exception {
        network = new StringWriter();
        application = new Application(new PrintWriter(network));
    }

    @Test public void sendsTheEmailOutToTheNetwork() {
        application.send(new Email(new ToAddress("joe@example.com"), new Body("Hi there!")));
        assertEquals("connect smtp\n" +
                "To: joe@example.com\n" +
                "\n" +
                "Hi there!\n" +
                "\n" +
                "disconnect\n", network.toString());
    }

    @Test public void sendsNothingIfTheEmailAddressIsInvalid() {
        application.send(new Email(new ToAddress("invalid!!!"), new Body("whatever")));
        assertEquals("", network.toString());
    }
}
