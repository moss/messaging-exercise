package net.m14m.katas.messaging.network;

import net.m14m.katas.messaging.message.*;

public class MailFormat implements Format {
    public String format(AddressList addressList, Body body) {
        return addressList.format("To: %s\n") + "\n" + body + "\n";
    }

    @Override public String toString() {
        return "smtp";
    }
}
