package net.m14m.katas.messaging;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ToAddressTest {
    @Mock
    private ErrorHandler handler;

    @Test public void validIfItHasAnAtSign() {
        new ToAddress("joe@example.com").reportProblems(handler);
        verify(handler, never()).error(any(Error.class));
    }

    @Test public void invalidIfItHasNoAtSign() {
        new ToAddress("!123").reportProblems(handler);
        verify(handler).error(refEq(new Error("Invalid email address: !123")));
    }
}
