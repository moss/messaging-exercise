package net.m14m.katas.messaging;

import org.junit.*;

import java.io.StringWriter;

import static org.junit.Assert.*;

public class NetworkTest {
    private static final Address VALID_ADDRESS = new Address("anita@example.com");
    private static final Address INVALID_ADDRESS = new Address("invalid");
    private static final Body BODY = new Body("Greetings.");
    private StringWriter output = new StringWriter();
    private Network network;

    @Before public void setUp() {
        network = new Network(output);
    }

    @Test public void sendEmailToSpecifiedAddressWithSpecifiedBody() {
        network.sendMail(new Message(VALID_ADDRESS, BODY));
        assertEquals("connect smtp\n" +
                "To: anita@example.com\n" +
                "\n" +
                "Greetings.\n" +
                "\n" +
                "disconnect\n", output.toString());
    }

    @Test public void shouldNotSendIfAddressIsInvalid() {
        network.sendMail(new Message(INVALID_ADDRESS, BODY));
        assertEquals("should send nothing", "", output.toString());
    }
}
