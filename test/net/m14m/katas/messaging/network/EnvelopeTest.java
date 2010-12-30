package net.m14m.katas.messaging.network;

import net.m14m.katas.messaging.message.*;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EnvelopeTest {
    @Mock private Message message;
    @Mock private Format format;
    private Writer connection = new StringWriter();
    private Envelope envelope;

    @Before public void setUp() throws Exception {
        envelope = new Envelope(message, format);
    }

    @Test public void formatsTheMessageAndSendsItThroughAConnection() {
        when(message.format(format)).thenReturn("Formatted Message");
        envelope.send(new PrintWriter(connection));
        assertEquals("connect format\nFormatted Message\ndisconnect\n", connection.toString());
    }
}
