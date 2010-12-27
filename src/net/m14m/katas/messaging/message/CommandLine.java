package net.m14m.katas.messaging.message;

public class CommandLine {
    private String[] arguments;

    public CommandLine(String... arguments) {
        this.arguments = arguments;
    }

    public Message parseMessage() {
        Address address = new Address(arguments[0]);
        Body body = new Body(arguments[1]);
        return new Message(new AddressList(address), body);
    }
}
