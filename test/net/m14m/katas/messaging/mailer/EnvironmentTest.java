package net.m14m.katas.messaging.mailer;

import net.m14m.katas.messaging.message.Message;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static net.m14m.katas.messaging.mailer.Format.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EnvironmentTest {
    @Mock private Message message;
    @Mock private ValidatingMailer smtpMailer;
    @Mock private ValidatingMailer chatMailer;
    private Environment environment;

    @Before public void setUp() throws Exception {
        environment = new Environment();
        environment.registerMailer(smtp, smtpMailer);
        environment.registerMailer(chat, chatMailer);
    }

    @Test public void sendSmtp() {
        environment.send(smtp, message);
        verify(message).sendThrough(smtpMailer);
    }

    @Test public void sendChat() {
        environment.send(chat, message);
        verify(message).sendThrough(chatMailer);
    }
}
