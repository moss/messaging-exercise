package net.m14m.katas.messaging.application;

import net.m14m.katas.messaging.mailer.*;
import net.m14m.katas.messaging.message.*;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static net.m14m.katas.messaging.message.ToAddressBlock.parseCommaSeparated;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CommandTest {
    private static final String TO = "a@example.com";
    private static final String BODY = "hello";
    private static final Message MESSAGE = new Message(parseCommaSeparated(TO), new Body(BODY));
    @Mock
    private Environment environment;

    @Test public void sendsSmtpByDefault() {
        Command command = new Command(TO, BODY);
        command.runIn(environment);
        verify(environment).send(Format.smtp, MESSAGE);
    }

    @Test public void sendsChatIfSpecifiedInArgument() {
        Command command = new Command("-im", TO, BODY);
        command.runIn(environment);
        verify(environment).send(Format.chat, MESSAGE);
    }
}
