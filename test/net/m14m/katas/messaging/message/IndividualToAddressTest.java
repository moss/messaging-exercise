package net.m14m.katas.messaging.message;

import net.m14m.katas.messaging.*;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class IndividualToAddressTest {
    @Mock
    private ErrorHandler handler;
    private StringWriter writer = new StringWriter();

    @Test public void appendsAddressToSomething() {
        new IndividualToAddress("joe@example.com").appendTo(new PrintWriter(writer));
        assertEquals("joe@example.com", writer.toString());
    }

    @Test public void validIfItHasAnAtSign() {
        new IndividualToAddress("joe@example.com").reportProblems(handler);
        verify(handler, never()).error(any(ValidationError.class));
    }

    @Test public void invalidIfItHasNoAtSign() {
        new IndividualToAddress("!123").reportProblems(handler);
        verify(handler).error(refEq(new ValidationError("Invalid email address: !123")));
    }
}
