package net.m14m.katas.messaging;

import org.junit.*;

import static org.junit.Assert.*;

public class AddressTest {
    @Test public void invalidIfItContainsNoAtSign() {
        assertTrue("with at sign", new Address("foo@bar.baz").isValid());
        assertFalse("no at sign", new Address("foo.bar.baz").isValid());
    }
}
