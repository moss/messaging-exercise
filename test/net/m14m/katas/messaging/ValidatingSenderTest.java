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
        validatingSender.send(VALID_ADDRESS, VALID_BODY);
        verify(sender).send(asList(VALID_ADDRESS), VALID_BODY);
    }

    @Test public void showsErrorAndDoesNotSendIfAddressInvalid() {
        validatingSender.send(new Address("invalid"), VALID_BODY);
        verify(sender, never()).send(asList(any(Address.class)), any(Body.class));
        assertEquals("Invalid email address: invalid\n", output.toString());
    }

    @Test public void showsErrorAndDoesNotSendIfTheBodyIsInvalid() {
        validatingSender.send(VALID_ADDRESS, new Body(""));
        verify(sender, never()).send(asList(any(Address.class)), any(Body.class));
        assertEquals("Cannot send an email with no body.\n", output.toString());
    }
}
