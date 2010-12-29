package net.m14m.katas.messaging.network;

import net.m14m.katas.messaging.errors.ErrorMessage;
import net.m14m.katas.messaging.message.*;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SenderTest {
    @Mock private Message message;
    private Writer connection = new StringWriter();
    private Sender sender;

    @Before public void setUp() {
        sender = new Sender(new PrintWriter(connection));
    }

    @Test public void sendEmailToSpecifiedAddressWithSpecifiedBody() {
        when(message.format(any(Format.class))).thenReturn("Formatted Message");
        sender.sendMail(new Envelope(message));
        assertEquals("connect smtp\nFormatted Message\ndisconnect\n", connection.toString());
    }

    @Test public void shouldNotSendIfNotifiedOfErrors() {
        sender.error(new ErrorMessage("Something's wrong."));
        sender.sendMail(new Envelope(message));
        assertEquals("", connection.toString());
    }
}
