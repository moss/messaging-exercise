package net.m14m.katas.messaging.mailer;

import net.m14m.katas.messaging.message.*;
import org.junit.*;

import java.io.*;

import static org.junit.Assert.*;

public class ChatMessageTest {
    private StringWriter network = new StringWriter();
    private ChatMessage message;

    @Before public void setUp() throws Exception {
        message = new ChatMessage(new Body("Hi."), new PrintWriter(network));
    }

    @Test public void repeatsMessageForEachToAddress() {
        message.append(new IndividualToAddress("a@example.com"));
        message.append(new IndividualToAddress("b@example.com"));
        assertEquals("<a@example.com>(Hi.)\n<b@example.com>(Hi.)\n", network.toString());
    }
}
