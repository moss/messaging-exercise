package net.m14m.katas.messaging.network;

import net.m14m.katas.messaging.message.*;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MailFormatTest {
    @Mock private AddressList addressList;
    @Mock private Body body;
    private MailFormat formatter;

    @Before public void setUp() {
        formatter = new MailFormat();
    }

    @Test public void sendEmailToSpecifiedAddressListWithSpecifiedBody() {
        when(addressList.format("To: %s\n")).thenReturn("some addresses");
        assertEquals("some addresses\nbody\n", formatter.format(addressList, body));
    }
}
