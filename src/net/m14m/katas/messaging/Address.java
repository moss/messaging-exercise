package net.m14m.katas.messaging;

class Address {
    private String address;

    public Address(String address) {
        this.address = address;
    }

    @Override public String toString() {
        return address;
    }

    public boolean isValid() {
        return address.contains("@");
    }
}
