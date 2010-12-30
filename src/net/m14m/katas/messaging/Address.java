package net.m14m.katas.messaging;

import java.util.*;

class Address {
    private String address;

    public static List<Address> listFrom(String addressString) {
        List<Address> addresses = new ArrayList<Address>();
        for (String address : addressString.split(",")) {
            addresses.add(new Address(address));
        }
        return addresses;
    }

    public Address(String address) {
        this.address = address;
    }

    @Override public String toString() {
        return address;
    }

    public boolean isValid() {
        return address.contains("@");
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
