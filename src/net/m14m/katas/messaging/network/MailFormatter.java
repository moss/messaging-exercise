package net.m14m.katas.messaging.network;

import net.m14m.katas.messaging.message.*;

public class MailFormatter implements Formatter {
    public String format(AddressList addressList, Body body) {
        return addressList + "\n" + body + "\n";
    }
}
