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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address that = (Address) o;
        return address.equals(that.address);
    }

    @Override
    public int hashCode() {
        return address.hashCode();
    }
}
