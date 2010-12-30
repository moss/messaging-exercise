package net.m14m.katas.messaging.network;

import net.m14m.katas.messaging.message.*;
import org.junit.*;

import static org.junit.Assert.*;

public class ChatFormatTest {
    private static final Body BODY = new Body("hello");
    private AddressList addressList = new AddressList();
    private ChatFormat format;

    @Before public void setUp() throws Exception {
        format = new ChatFormat();
    }

    @Test public void formatsMessage() {
        addressList.addRecipient(new Address("paula@example.com"));
        String result = format.format(addressList, BODY);
        assertEquals("<paula@example.com>(hello)", result);
    }
}
