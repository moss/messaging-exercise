package net.m14m.katas.messaging.message;

import net.m14m.katas.messaging.errors.*;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MessageTest {
    private static final Address VALID_ADDRESS = new Address("a@b.c");
    private static final Body VALID_BODY = new Body("hi");
    @Mock private ErrorListener listener;

    @Test public void validIfBothPartsAreValid() {
        Message message = new Message(new AddressList(VALID_ADDRESS), VALID_BODY);
        message.validate(listener);
        verify(listener, never()).error(any(ErrorMessage.class));
    }

    @Test public void invalidIfEmailAddressIsInvalid() {
        Message message = new Message(new AddressList(new Address("a")), VALID_BODY);
        message.validate(listener);
        verify(listener).error(any(ErrorMessage.class));
    }

    @Test public void invalidIfBodyIsEmpty() {
        Message message = new Message(new AddressList(VALID_ADDRESS), new Body(""));
        message.validate(listener);
        verify(listener).error(any(ErrorMessage.class));
    }
}
