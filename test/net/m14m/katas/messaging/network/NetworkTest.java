package net.m14m.katas.messaging.network;

import net.m14m.katas.messaging.errors.ErrorMessage;
import net.m14m.katas.messaging.message.*;
import org.junit.*;

import java.io.StringWriter;

import static net.m14m.katas.messaging.message.MessageFactory.createMessage;
import static org.junit.Assert.*;

public class NetworkTest {
    private static final Address ADDRESS = new Address("anita@example.com");
    private static final Body BODY = new Body("Greetings.");
    private static final Message MESSAGE = createMessage(BODY, ADDRESS);
    private StringWriter output = new StringWriter();
    private Network network;

    @Before public void setUp() {
        network = new Network(output);
    }

    @Test public void sendEmailToSpecifiedAddressWithSpecifiedBody() {
        network.sendMail(MESSAGE);
        assertEquals("connect smtp\n" +
                "To: anita@example.com\n" +
                "\n" +
                "Greetings.\n" +
                "\n" +
                "disconnect\n", output.toString());
    }

    @Test public void shouldNotSendIfNotifiedOfErrors() {
        network.error(new ErrorMessage("Something's wrong."));
        network.sendMail(MESSAGE);
        assertEquals("should send nothing", "", output.toString());
    }
}
