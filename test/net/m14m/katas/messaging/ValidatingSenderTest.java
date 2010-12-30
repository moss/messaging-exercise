package net.m14m.katas.messaging;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ValidatingSenderTest {
    @Mock private Sender sender;
    private Writer output = new StringWriter();
    private ValidatingSender validatingSender;

    @Before public void setUp() throws Exception {
        validatingSender = new ValidatingSender(sender, new PrintWriter(output));
    }

    @Test public void showsErrorAndDoesNotSendIfAddressInvalid() {
        validatingSender.send(new Address("invalid"), new Body("foo"));
        verify(sender, never()).send(any(Address.class), any(Body.class));
        assertEquals("Invalid email address: invalid\n", output.toString());
    }
}
