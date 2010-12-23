package net.m14m.katas.messaging;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ValidatingMailerTest {
    private static final ToAddress VALID_ADDRESS = new ToAddress("joe@example.com");
    private static final Body BODY = new Body("Hi there!");
    private static final ToAddress INVALID_ADDRESS = new ToAddress("not valid");
    @Mock
    private Mailer mailer;
    private StringWriter console = new StringWriter();
    private ValidatingMailer validatingMailer;

    @Before public void setUp() throws Exception {
        validatingMailer = new ValidatingMailer(mailer, new PrintWriter(console));
    }

    @Test public void shouldSendIfValid() {
        validatingMailer.send(VALID_ADDRESS, BODY);
        verify(mailer).send(VALID_ADDRESS, BODY);
    }

    @Test public void shouldNotSendIfInvalid() {
        validatingMailer.send(INVALID_ADDRESS, BODY);
        verify(mailer, never()).send(any(ToAddress.class), any(Body.class));
    }

    @Test public void reportsErrors() {
        validatingMailer.error(new Error("There was an error."));
        assertEquals("There was an error.\n", console.toString());
    }
}
