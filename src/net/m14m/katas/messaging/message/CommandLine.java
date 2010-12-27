package net.m14m.katas.messaging.message;

import java.util.ArrayList;

public class CommandLine {
    private String[] arguments;

    public CommandLine(String... arguments) {
        this.arguments = arguments;
    }

    public Message parseMessage() {
        AddressList addressList = parseAddressList();
        Body body = new Body(arguments[1]);
        return new Message(addressList, body);
    }

    private AddressList parseAddressList() {
        ArrayList<Address> list = new ArrayList<Address>();
        addAddresses(list);
        return new AddressList(list);
    }

    private void addAddresses(ArrayList<Address> list) {
        for (String address : arguments[0].split(",")) {
            list.add(new Address(address));
        }
    }
}
