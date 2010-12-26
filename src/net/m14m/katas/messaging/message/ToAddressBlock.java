package net.m14m.katas.messaging.message;

import net.m14m.katas.messaging.*;

import java.util.*;

public class ToAddressBlock {
    private final List<IndividualToAddress> addresses;

    public static ToAddressBlock parseCommaSeparated(String fullAddressString) {
        List<IndividualToAddress> addresses = new ArrayList<IndividualToAddress>();
        for (String individualAddressString : fullAddressString.split(",")) {
            addresses.add(new IndividualToAddress(individualAddressString));
        }
        return new ToAddressBlock(addresses);
    }

    private ToAddressBlock(List<IndividualToAddress> addresses) {
        this.addresses = addresses;
    }

    public void writeHeader(ToAddressFormatter formatter) {
        for (IndividualToAddress address : addresses) {
            formatter.append(address);
        }
    }

    public void reportProblems(ErrorHandler handler) {
        for (IndividualToAddress address : addresses) {
            address.reportProblems(handler);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ToAddressBlock that = (ToAddressBlock) o;
        return addresses.equals(that.addresses);
    }

    @Override
    public int hashCode() {
        return addresses.hashCode();
    }
}
