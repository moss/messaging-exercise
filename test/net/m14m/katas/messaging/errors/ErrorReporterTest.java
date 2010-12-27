package net.m14m.katas.messaging.errors;

import org.junit.*;

import java.io.StringWriter;

import static org.junit.Assert.*;

public class ErrorReporterTest {
    private StringWriter console = new StringWriter();
    private ErrorListener listener;

    @Before public void setUp() throws Exception {
        listener = new ErrorReporter(console);
    }

    @Test public void reportsErrorMessagesToTheConsole() {
        listener.error(new ErrorMessage("Something went wrong."));
        assertEquals("Something went wrong.\n", console.toString());
    }
}
