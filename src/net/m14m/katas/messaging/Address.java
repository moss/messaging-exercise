package net.m14m.katas.messaging;

public class Address {
    private final String address;

    public Address(String address) {
        this.address = address;
    }

    @Override public String toString() {
        return address;
    }
}
