package net.m14m.katas.messaging;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BodyTest {
    @Mock
    private ErrorHandler errorHandler;

    @Test public void validIfNonEmpty() {
        new Body("This is some text.").reportProblems(errorHandler);
        verify(errorHandler, never()).error(any(Error.class));
    }

    @Test public void invalidIfEmpty() {
        new Body("").reportProblems(errorHandler);
        verify(errorHandler).error(refEq(new Error("Cannot send an email with no body.")));
    }
}
