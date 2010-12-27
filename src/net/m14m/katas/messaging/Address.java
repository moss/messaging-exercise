package net.m14m.katas.messaging;

public class Address {
    private final String address;

    public Address(String address) {
        this.address = address;
    }

    public void validate(ErrorListener listener) {
        if (!isValid()) listener.error(ErrorMessage.withCause("Invalid email address", this));
    }

    public boolean isValid() {
        return address.contains("@");
    }

    @Override public String toString() {
        return address;
    }
}
