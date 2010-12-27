package net.m14m.katas.messaging;

import org.junit.*;

import java.io.StringWriter;

import static org.junit.Assert.*;

public class NetworkTest {
    private StringWriter output = new StringWriter();
    private Network network;

    @Before public void setUp() {
        network = new Network(output);
    }

    @Test public void sendEmailToSpecifiedAddressWithSpecifiedBody() {
        network.sendMail(new Address("anita@example.com"), new Body("Greetings."));
        assertEquals("connect smtp\n" +
                "To: anita@example.com\n" +
                "\n" +
                "Greetings.\n" +
                "\n" +
                "disconnect\n", output.toString());
    }
}
