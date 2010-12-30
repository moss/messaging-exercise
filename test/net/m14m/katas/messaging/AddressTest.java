package net.m14m.katas.messaging;

import org.junit.*;

import static org.junit.Assert.*;

public class AddressTest {
    @Test public void invalidIfHasNoAtSign() {
        assertTrue("valid", new Address("a@b").isValid());
        assertFalse("invalid", new Address("ab").isValid());
    }
}
