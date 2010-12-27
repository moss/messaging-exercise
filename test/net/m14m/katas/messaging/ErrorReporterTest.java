package net.m14m.katas.messaging;

import org.junit.*;

import java.io.StringWriter;

import static org.junit.Assert.*;

public class ErrorReporterTest {
    private StringWriter console = new StringWriter();
    private ErrorReporter reporter;

    @Before public void setUp() throws Exception {
        reporter = new ErrorReporter(console);
    }

    @Test public void reportsErrorMessagesToTheConsole() {
        reporter.error(new ErrorMessage("Something went wrong."));
        assertEquals("Something went wrong.\n", console.toString());
    }
}
