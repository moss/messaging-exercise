package net.m14m.katas.messaging;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.*;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ValidatingSenderTest {
    private static final Address VALID_ADDRESS = new Address("a@b.com");
    private static final Body VALID_BODY = new Body("foo");
    @Mock private Sender sender;
    private Writer output = new StringWriter();
    private ValidatingSender validatingSender;

    @Before public void setUp() throws Exception {
        validatingSender = new ValidatingSender(sender, new PrintWriter(output));
    }

    @Test public void sendsIfEverythingIsValid() {
        validatingSender.send(VALID_BODY, asList(VALID_ADDRESS));
        verify(sender).send(asList(VALID_ADDRESS), VALID_BODY);
    }

    @Test public void showsErrorAndDoesNotSendIfAddressInvalid() {
        final Address invalid = new Address("invalid");
        validatingSender.send(VALID_BODY, asList(invalid));
        verify(sender, never()).send(asList(any(Address.class)), any(Body.class));
        assertEquals("Invalid email address: invalid\n", output.toString());
    }

    @Test public void showsErrorAndDoesNotSendIfTheBodyIsInvalid() {
        validatingSender.send(new Body(""), asList(VALID_ADDRESS));
        verify(sender, never()).send(asList(any(Address.class)), any(Body.class));
        assertEquals("Cannot send an email with no body.\n", output.toString());
    }
}
