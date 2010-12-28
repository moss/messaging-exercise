package net.m14m.katas.messaging.network;

import net.m14m.katas.messaging.message.*;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MailFormatterTest {
    @Mock private AddressList addressList;
    @Mock private Body body;
    private MailFormatter formatter;

    @Before public void setUp() {
        formatter = new MailFormatter();
    }

    @Test public void sendEmailToSpecifiedAddressListWithSpecifiedBody() {
        assertEquals("addressList\nbody\n", formatter.format(addressList, body));
    }
}
