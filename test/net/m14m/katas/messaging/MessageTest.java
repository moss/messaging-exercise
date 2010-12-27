package net.m14m.katas.messaging;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MessageTest {
    private static final Address VALID_ADDRESS = new Address("a@b.c");
    private static final Body VALID_BODY = new Body("hi");
    @Mock private ErrorListener listener;

    @Test public void validIfBothPartsAreValid() {
        Message message = new Message(VALID_ADDRESS, VALID_BODY);
        message.validate(listener);
        assertTrue("valid", message.isValid());
        verify(listener, never()).error(any(ErrorMessage.class));
    }

    @Test public void invalidIfEmailAddressIsInvalid() {
        Message message = new Message(new Address("a"), VALID_BODY);
        message.validate(listener);
        assertFalse("invalid", message.isValid());
        verify(listener).error(any(ErrorMessage.class));
    }

    @Test public void invalidIfBodyIsEmpty() {
        Message message = new Message(VALID_ADDRESS, new Body(""));
        message.validate(listener);
        assertFalse("invalid", message.isValid());
        verify(listener).error(any(ErrorMessage.class));
    }
}