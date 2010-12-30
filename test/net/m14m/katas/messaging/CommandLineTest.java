package net.m14m.katas.messaging;

import org.junit.*;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class CommandLineTest {
    @Test public void argsForMailMessage() {
        CommandLine commandLine = new CommandLine("a@b.com", "hello");
        assertEquals(asList(new Address("a@b.com")), commandLine.getAddresses());
        assertEquals(new Body("hello"), commandLine.getBody());
        assertThat(commandLine.createSender(null), instanceOf(MailSender.class));
    }

    @Test public void argsForChatMessage() {
        CommandLine commandLine = new CommandLine("-im", "a@b.com", "hello");
        assertEquals(asList(new Address("a@b.com")), commandLine.getAddresses());
        assertEquals(new Body("hello"), commandLine.getBody());
        assertThat(commandLine.createSender(null), instanceOf(ChatSender.class));
    }
}
