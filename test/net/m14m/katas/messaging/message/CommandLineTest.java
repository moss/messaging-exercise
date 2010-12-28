package net.m14m.katas.messaging.message;

import org.junit.*;

import static net.m14m.katas.messaging.message.MessageFactory.createMessage;
import static org.junit.Assert.*;

public class CommandLineTest {
    @Test public void createsAMessage() {
        CommandLine commandLine = new CommandLine("jo@example.com", "hello");
        Message expectedMessage = createMessage(new Body("hello"), new Address("jo@example.com"));
        assertEquals(expectedMessage, commandLine.parseMessage());
    }

    @Test public void createsAMessageWithMultipleToAddresse() {
        CommandLine commandLine = new CommandLine("jo@example.com,bill@example.com", "hello");
        Message expectedMessage = createMessage(new Body("hello"),
                new Address("jo@example.com"), new Address("bill@example.com"));
        assertEquals(expectedMessage, commandLine.parseMessage());
    }
}
