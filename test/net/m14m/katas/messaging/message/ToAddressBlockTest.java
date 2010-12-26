package net.m14m.katas.messaging.message;

import net.m14m.katas.messaging.ErrorHandler;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.*;

import static net.m14m.katas.messaging.message.ToAddressBlock.parseCommaSeparated;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ToAddressBlockTest {
    private StringWriter network = new StringWriter();
    @Mock
    private ErrorHandler errorHandler;

    @Test public void shouldWriteEachAddress() {
        ToAddressBlock block = parseCommaSeparated("a@example.com,b@example.com");
        block.writeHeader(new PrintWriter(network));
        assertEquals("To: a@example.com\nTo: b@example.com\n", network.toString());
    }

    @Test public void shouldReportAllErrors() {
        ToAddressBlock block = parseCommaSeparated("bad address,ok@example.com,other bad address");
        block.reportProblems(errorHandler);
        verify(errorHandler, times(2)).error(any(net.m14m.katas.messaging.Error.class));
    }
}
