package net.m14m.katas.messaging.network;

import net.m14m.katas.messaging.message.*;

public class MailFormat implements Format {
    public String format(AddressList addressList, Body body) {
        return addressList + "\n" + body + "\n";
    }
}
