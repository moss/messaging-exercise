package net.m14m.katas.messaging;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AddressTest {
    @Mock private ErrorListener listener;

    @Test public void validIfItContainsAnAtSign() {
        Address address = new Address("foo@bar.baz");
        address.validate(listener);
        verify(listener, never()).error(any(ErrorMessage.class));
    }

    @Test public void invalidIfItContainsNoAtSign() {
        Address address = new Address("foo.bar.baz");
        address.validate(listener);
        verify(listener).error(any(ErrorMessage.class));
    }
}
