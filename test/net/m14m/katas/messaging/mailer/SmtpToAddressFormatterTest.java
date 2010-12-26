package net.m14m.katas.messaging.mailer;

import net.m14m.katas.messaging.ErrorHandler;
import net.m14m.katas.messaging.message.IndividualToAddress;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SmtpToAddressFormatterTest {
    private StringWriter network = new StringWriter();
    @Mock
    private ErrorHandler errorHandler;
    private SmtpToAddressFormatter formatter;

    @Before public void setUp() throws Exception {
        formatter = new SmtpToAddressFormatter(new PrintWriter(network));
    }

    @Test public void shouldWriteEachAddress() {
        formatter.append(new IndividualToAddress("a@example.com"));
        formatter.append(new IndividualToAddress("b@example.com"));
        assertEquals("To: a@example.com\nTo: b@example.com\n", network.toString());
    }
}
