package net.m14m.katas.messaging.message;

import net.m14m.katas.messaging.errors.ErrorListener;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MessageTest {
    @Mock private ErrorListener listener;
    @Mock private AddressList addressList;
    @Mock private Body body;
    @Mock private Format format;
    private Message message;

    @Before public void setUp() {
        message = new Message(addressList, body);
    }

    @Test public void validatesAllParts() {
        message.validate(listener);
        verify(addressList).validate(listener);
        verify(body).validate(listener);
    }

    @Test public void formatTheMessageUsingAFormatter() {
        when(format.format(addressList, body)).thenReturn("Formatted Message");
        assertEquals("Formatted Message", message.format(format));
    }
}
