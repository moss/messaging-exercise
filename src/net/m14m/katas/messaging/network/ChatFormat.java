package net.m14m.katas.messaging.network;

import net.m14m.katas.messaging.message.*;

public class ChatFormat implements Format {
    public String format(AddressList addressList, Body body) {
        return String.format("<%s>(%s)", addressList, body);
    }
}
