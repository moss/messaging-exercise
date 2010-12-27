package net.m14m.katas.messaging.message;

import org.junit.*;

import static org.junit.Assert.*;

public class CommandLineTest {
    @Test public void createsAMessage() {
        CommandLine commandLine = new CommandLine("jo@example.com", "hello");
        assertEquals(new Message(new AddressList(new Address("jo@example.com")), new Body("hello")),
                commandLine.parseMessage());
    }
}
