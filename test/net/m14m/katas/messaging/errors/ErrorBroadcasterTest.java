package net.m14m.katas.messaging.errors;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ErrorBroadcasterTest {
    @Mock private ErrorListener oneListener;
    @Mock private ErrorListener anotherListener;
    @Mock private ErrorMessage message;
    private ErrorBroadcaster broadcaster;

    @Before public void setUp() throws Exception {
        broadcaster = new ErrorBroadcaster(oneListener, anotherListener);
    }

    @Test public void broadcastsErrorMessagesToAllListeners() {
        broadcaster.error(message);
        verify(oneListener).error(message);
        verify(anotherListener).error(message);
    }
}
