package net.m14m.katas.messaging.network;

import net.m14m.katas.messaging.errors.*;
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
    @Mock private ErrorListener listener;
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

    @Test public void validatesConnectionProblems() {
        when(connection.checkError()).thenReturn(true);
        sender.validate(listener);
        verify(listener).error(any(ErrorMessage.class));
    }

    @Test public void validIfThereAreNoConnectionProblems() {
        when(connection.checkError()).thenReturn(false);
        sender.validate(listener);
        verify(listener, never()).error(any(ErrorMessage.class));
    }
}
