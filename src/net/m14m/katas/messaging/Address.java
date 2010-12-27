package net.m14m.katas.messaging;

public class Address {
    private final String address;

    public Address(String address) {
        this.address = address;
    }

    public boolean isValid() {
        return address.contains("@");
    }

    @Override public String toString() {
        return address;
    }
}
