package net.m14m.katas.messaging.network;

import net.m14m.katas.messaging.errors.ErrorMessage;
import net.m14m.katas.messaging.message.Message;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintWriter;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SenderTest {
    @Mock private Message message;
    @Mock private PrintWriter connection;
    private Sender sender;

    @Before public void setUp() {
        sender = new Sender(connection);
    }

    @Test public void sendEmailToSpecifiedAddressWithSpecifiedBody() {
        sender.sendMail(message);
        verify(message).writeTo(connection);
    }

    @Test public void shouldNotSendIfNotifiedOfErrors() {
        sender.error(new ErrorMessage("Something's wrong."));
        sender.sendMail(message);
        verify(message, never()).writeTo(any(PrintWriter.class));
    }
}
