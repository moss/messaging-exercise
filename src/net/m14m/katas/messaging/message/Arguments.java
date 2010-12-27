package net.m14m.katas.messaging.message;

public class Arguments {
    private String[] arguments;

    public Arguments(String... arguments) {
        this.arguments = arguments;
    }

    public Message createMessage() {
        Address address = new Address(arguments[0]);
        Body body = new Body(arguments[1]);
        return new Message(new AddressList(address), body);
    }
}
