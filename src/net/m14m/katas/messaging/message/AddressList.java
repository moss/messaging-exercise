package net.m14m.katas.messaging.message;

import net.m14m.katas.messaging.errors.ErrorListener;

public class AddressList {
    private final Address[] addresses;

    public AddressList(Address... addresses) {
        this.addresses = addresses;
    }

    public void validate(ErrorListener listener) {
        for (Address address : addresses) {
            address.validate(listener);
        }
    }

    @Override public String toString() {
        StringBuilder result = new StringBuilder();
        addToHeaders(result);
        return result.toString();
    }

    private void addToHeaders(StringBuilder result) {
        for (Address address : addresses) {
            result.append("To: ").append(address).append("\n");
        }
    }
}
