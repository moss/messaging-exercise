package net.m14m.katas.messaging.message;

import org.junit.*;

import static org.junit.Assert.*;

public class CommandLineTest {
    @Test public void createsAMessage() {
        CommandLine commandLine = new CommandLine("jo@example.com", "hello");
        assertEquals(new Message(new AddressList(new Address("jo@example.com")), new Body("hello")),
                commandLine.parseMessage());
    }

    @Test public void createsAMessageWithMultipleToAddresse() {
        CommandLine commandLine = new CommandLine("jo@example.com,bill@example.com", "hello");
        AddressList expectedAddressList = new AddressList(
                new Address("jo@example.com"),
                new Address("bill@example.com")
        );
        assertEquals(new Message(expectedAddressList, new Body("hello")),
                commandLine.parseMessage());
    }
}
