package net.m14m.katas.messaging.network;

import net.m14m.katas.messaging.message.*;

public class ChatFormat implements Format {
    public String format(AddressList addressList, Body body) {
        return "<" + addressList.format("%s") + ">(" + escapeClosingParentheses(body) + ")";
    }

    private String escapeClosingParentheses(Body body) {
        String text = body.toString();
        return text.replace(")", "\\)");
    }
}
