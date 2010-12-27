package net.m14m.katas.messaging.message;

import net.m14m.katas.messaging.errors.*;

public class Address {
    private final String address;

    public Address(String address) {
        this.address = address;
    }

    public void validate(ErrorListener listener) {
        if (!address.contains("@")) {
            listener.error(ErrorMessage.withCause("Invalid email address", this));
        }
    }

    @Override public String toString() {
        return address;
    }
}
