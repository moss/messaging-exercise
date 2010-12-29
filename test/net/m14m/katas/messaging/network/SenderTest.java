package net.m14m.katas.messaging.network;

import net.m14m.katas.messaging.errors.ErrorMessage;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintWriter;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SenderTest {
    @Mock private Envelope envelope;
    @Mock private PrintWriter connection;
    private Sender sender;

    @Before public void setUp() {
        sender = new Sender(connection);
    }

    @Test public void sendTheEnvelopeUsingTheConnection() {
        sender.sendMail(envelope);
        verify(envelope).send(connection);
    }

    @Test public void shouldNotSendIfNotifiedOfErrors() {
        sender.error(new ErrorMessage("Something's wrong."));
        sender.sendMail(envelope);
        verify(envelope, never()).send(any(PrintWriter.class));
    }
}
