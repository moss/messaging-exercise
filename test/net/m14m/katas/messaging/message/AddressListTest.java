package net.m14m.katas.messaging.message;

import net.m14m.katas.messaging.errors.ErrorListener;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AddressListTest {
    @Mock private ErrorListener listener;
    @Mock private Address address1;
    @Mock private Address address2;
    private AddressList addressList;

    @Before public void setUp() throws Exception {
        addressList = new AddressList(address1, address2);
    }

    @Test public void validatesAllAddresses() {
        addressList.validate(listener);
        verify(address1).validate(listener);
        verify(address2).validate(listener);
    }

    @Test public void includesToLinesForAllAddresses() {
        assertEquals("To: address1\nTo: address2\n", addressList.toString());
    }
}
