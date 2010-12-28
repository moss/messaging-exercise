package net.m14m.katas.messaging.message;

public class CommandLine {
    private String[] arguments;

    public CommandLine(String... arguments) {
        this.arguments = arguments;
    }

    public Message parseMessage() {
        AddressList addressList = new AddressList();
        addRecipients(addressList);
        Body body = new Body(arguments[1]);
        return new Message(addressList, body);
    }

    private void addRecipients(AddressList addressList) {
        for (String address : arguments[0].split(",")) {
            addressList.addRecipient(new Address(address));
        }
    }
}
