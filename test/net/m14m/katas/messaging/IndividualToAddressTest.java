package net.m14m.katas.messaging;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class IndividualToAddressTest {
    @Mock
    private ErrorHandler handler;

    @Test public void validIfItHasAnAtSign() {
        new IndividualToAddress("joe@example.com").reportProblems(handler);
        verify(handler, never()).error(any(Error.class));
    }

    @Test public void invalidIfItHasNoAtSign() {
        new IndividualToAddress("!123").reportProblems(handler);
        verify(handler).error(refEq(new Error("Invalid email address: !123")));
    }
}
