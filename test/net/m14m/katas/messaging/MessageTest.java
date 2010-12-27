package net.m14m.katas.messaging;

import org.junit.*;

import static org.junit.Assert.*;

public class MessageTest {
    private static final Address VALID_ADDRESS = new Address("a@b.c");
    private static final Body VALID_BODY = new Body("hi");

    @Test public void validIfBothPartsAreValid() {
        Message message = new Message(VALID_ADDRESS, VALID_BODY);
        assertTrue("valid", message.isValid());
    }

    @Test public void invalidIfEmailAddressIsInvalid() {
        Message message = new Message(new Address("a"), VALID_BODY);
        assertFalse("invalid", message.isValid());
    }

    @Test public void invalidIfBodyIsEmpty() {
        Message message = new Message(VALID_ADDRESS, new Body(""));
        assertFalse("invalid", message.isValid());
    }
}
