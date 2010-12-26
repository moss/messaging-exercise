package net.m14m.katas.messaging.message;

import net.m14m.katas.messaging.*;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static net.m14m.katas.messaging.message.ToAddressBlock.parseCommaSeparated;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ToAddressBlockTest {
    @Mock
    private ErrorHandler errorHandler;
    @Mock
    private ToAddressFormatter formatter;

    @Test public void shouldWriteEachAddress() {
        ToAddressBlock block = parseCommaSeparated("a@example.com,b@example.com");
        block.writeHeader(formatter);
        verify(formatter).append(new IndividualToAddress("a@example.com"));
        verify(formatter).append(new IndividualToAddress("b@example.com"));
    }

    @Test public void shouldReportAllErrors() {
        ToAddressBlock block = parseCommaSeparated("bad address,ok@example.com,other bad address");
        block.reportProblems(errorHandler);
        verify(errorHandler, times(2)).error(any(ValidationError.class));
    }
}
