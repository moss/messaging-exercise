package net.m14m.katas.messaging.message;

public class MessageFactory {
    public static Message createMessage(Body body, Address... addresses) {
        AddressList addressList = new AddressList();
        for (Address address : addresses) {
            addressList.addRecipient(address);
        }
        return new Message(addressList, body);
    }
}
