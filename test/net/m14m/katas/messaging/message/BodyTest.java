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
public class BodyTest {
    private static final String TEXT = "This is (some) text.";
    private static final String EMPTY_TEXT = "";
    @Mock
    private ErrorHandler errorHandler;
    private StringWriter writer = new StringWriter();
    private Body validBody;

    @Before public void setUp() throws Exception {
        validBody = new Body(TEXT);
    }

    @Test public void writesToAPrintStream() {
        validBody.writeTo(new PrintWriter(writer));
        assertEquals(TEXT, writer.toString());
    }

    @Test public void canWriteEscapingClosingParentheses() {
        validBody.writeEscapingParentheses(new PrintWriter(writer));
        assertEquals("This is (some\\) text.", writer.toString());
    }

    @Test public void validIfNonEmpty() {
        validBody.reportProblems(errorHandler);
        verify(errorHandler, never()).error(any(ValidationError.class));
    }

    @Test public void invalidIfEmpty() {
        new Body(EMPTY_TEXT).reportProblems(errorHandler);
        verify(errorHandler).error(new ValidationError("Cannot send an email with no body."));
    }
}
