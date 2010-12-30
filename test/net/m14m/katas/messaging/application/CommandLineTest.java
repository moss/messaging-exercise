package net.m14m.katas.messaging.application;

import net.m14m.katas.messaging.message.*;
import net.m14m.katas.messaging.network.*;
import org.junit.*;

import static net.m14m.katas.messaging.message.MessageFactory.createMessage;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class CommandLineTest {
    private static final String ADDRESS = "jo@example.com";
    private static final String BODY = "hello";

    @Test public void createsAMessage() {
        CommandLine commandLine = new CommandLine(ADDRESS, BODY);
        Message expectedMessage = createMessage(new Body(BODY), new Address(ADDRESS));
        assertEquals(expectedMessage, commandLine.parseMessage());
    }

    @Test public void createsAMessageWithMultipleToAddresse() {
        CommandLine commandLine = new CommandLine("jo@example.com,bill@example.com", BODY);
        Message expectedMessage = createMessage(new Body(BODY),
                new Address(ADDRESS), new Address("bill@example.com"));
        assertEquals(expectedMessage, commandLine.parseMessage());
    }

    @Test public void defaultMessageFormatIsMail() {
        CommandLine commandLine = new CommandLine(ADDRESS, BODY);
        assertThat(commandLine.parseFormat(), instanceOf(MailFormat.class));
    }

    @Test public void initialSwitchToGetChatMessageInsteadOfMail() {
        CommandLine commandLine = new CommandLine("-im", ADDRESS, BODY);
        assertThat(commandLine.parseFormat(), instanceOf(ChatFormat.class));
    }

    @Test public void buildsChatMessageCorrectly() {
        CommandLine commandLine = new CommandLine("-im", ADDRESS, BODY);
        Message expectedMessage = createMessage(new Body(BODY), new Address(ADDRESS));
        assertEquals(expectedMessage, commandLine.parseMessage());
    }
}
