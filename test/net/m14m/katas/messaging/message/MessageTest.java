package net.m14m.katas.messaging.message;

import net.m14m.katas.messaging.errors.ErrorListener;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MessageTest {
    @Mock private ErrorListener listener;
    @Mock private AddressList addressList;
    @Mock private Body body;
    private Message message;

    @Before public void setUp() {
        message = new Message(addressList, body);
    }

    @Test public void validatesAllParts() {
        message.validate(listener);
        verify(addressList).validate(listener);
        verify(body).validate(listener);
    }
}
