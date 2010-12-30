package net.m14m.katas.messaging;

import org.junit.*;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class AddressTest {
    @Test public void invalidIfHasNoAtSign() {
        assertTrue("valid", new Address("a@b").isValid());
        assertFalse("invalid", new Address("ab").isValid());
    }

    @Test public void parseACommaSeparatedList() {
        assertEquals(asList(new Address("a@b.com"), new Address("b@c.com")),
                Address.listFrom("a@b.com,b@c.com"));
    }
}
