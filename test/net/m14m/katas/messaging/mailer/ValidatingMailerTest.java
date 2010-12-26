package net.m14m.katas.messaging.mailer;

import net.m14m.katas.messaging.*;
import net.m14m.katas.messaging.message.*;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ValidatingMailerTest {
    private static final ToAddressBlock ADDRESS = ToAddressBlock
            .parseCommaSeparated("joe@example.com");
    private static final Body BODY = new Body("Hi there!");
    private static final ToAddressBlock INVALID_ADDRESS = ToAddressBlock
            .parseCommaSeparated("not valid");
    private static final Body INVALID_BODY = new Body("");
    @Mock
    private Mailer mailer;
    private StringWriter console = new StringWriter();
    private ValidatingMailer validatingMailer;

    @Before public void setUp() throws Exception {
        validatingMailer = new ValidatingMailer(mailer, new PrintWriter(console));
    }

    @Test public void shouldSendIfValid() {
        validatingMailer.send(ADDRESS, BODY);
        verify(mailer).send(ADDRESS, BODY);
    }

    @Test public void shouldValidateToAddress() {
        validatingMailer.send(INVALID_ADDRESS, BODY);
        verify(mailer, never()).send(any(ToAddressBlock.class), any(Body.class));
        assertReportedAnError();
    }

    @Test public void shouldValidateBody() {
        validatingMailer.send(ADDRESS, INVALID_BODY);
        verify(mailer, never()).send(any(ToAddressBlock.class), any(Body.class));
        assertReportedAnError();
    }

    @Test public void reportsErrors() {
        validatingMailer.error(new ValidationError("There was an error."));
        assertEquals("There was an error.\n", output());
    }

    private void assertReportedAnError() {
        assertFalse("should have reported an error", output().isEmpty());
    }

    private String output() {
        return console.toString();
    }
}
