package net.m14m.katas.messaging.network;

import net.m14m.katas.messaging.message.*;

public class ChatFormat implements Format {
    public String format(AddressList addressList, Body body) {
        String escapedBody = escapeClosingParentheses(body);
        String perAddressFormat = "<%s>(" + escapedBody + ")\n";
        String multipleLines = addressList.format(perAddressFormat);
        return omitFinalNewline(multipleLines);
    }

    private String escapeClosingParentheses(Body body) {
        String text = body.toString();
        text = text.replace(")", "\\)");
        return text.replace("%", "%%");
    }

    private String omitFinalNewline(String multipleLines) {
        return multipleLines.substring(0, multipleLines.length() - 1);
    }

    @Override public String toString() {
        return "chat";
    }
}
