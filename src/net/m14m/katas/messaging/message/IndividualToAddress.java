package net.m14m.katas.messaging.message;

import net.m14m.katas.messaging.*;

import java.io.PrintWriter;

public class IndividualToAddress {
    private final String address;

    public IndividualToAddress(String address) {
        this.address = address;
    }

    public void appendTo(PrintWriter writer) {
        writer.print(address);
    }

    public void reportProblems(ErrorHandler handler) {
        if (!address.contains("@"))
            handler.error(new ValidationError("Invalid email address: " + address));
    }
}
