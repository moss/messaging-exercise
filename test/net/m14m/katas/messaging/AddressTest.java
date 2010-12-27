package net.m14m.katas.messaging;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AddressTest {
    @Mock private ErrorReporter errorReporter;

    @Test public void validIfItContainsAnAtSign() {
        Address address = new Address("foo@bar.baz");
        address.validate(errorReporter);
        assertTrue("with at sign", address.isValid());
        verify(errorReporter, never()).error(any(ErrorMessage.class));
    }

    @Test public void invalidIfItContainsNoAtSign() {
        Address address = new Address("foo.bar.baz");
        address.validate(errorReporter);
        assertFalse("no at sign", address.isValid());
        verify(errorReporter).error(any(ErrorMessage.class));
    }
}
