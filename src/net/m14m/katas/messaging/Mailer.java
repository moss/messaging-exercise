package net.m14m.katas.messaging;

import net.m14m.katas.messaging.message.*;

public interface Mailer {
    void send(ToAddressBlock to, Body body);
}
