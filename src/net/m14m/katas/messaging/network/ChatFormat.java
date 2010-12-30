package net.m14m.katas.messaging.network;

import net.m14m.katas.messaging.message.*;

public class ChatFormat implements Format {
    public String format(AddressList addressList, Body body) {
        return "<" + addressList.format("%s") + ">(" + escapeParens(body) + ")";
    }

    private String escapeParens(Body body) {
        String text = body.toString();
        return text.replace(")", "\\)");
    }
}
