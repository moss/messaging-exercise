package net.m14m.katas.messaging.application;

import net.m14m.katas.messaging.message.*;
import net.m14m.katas.messaging.network.*;

import java.util.List;

import static java.util.Arrays.asList;

public class CommandLine {
    private List<String> arguments;

    public CommandLine(String... arguments) {
        this.arguments = asList(arguments);
    }

    public Message parseMessage() {
        AddressList addressList = new AddressList();
        addRecipients(addressList);
        Body body = new Body(nonSwitchArgument(1));
        return new Message(addressList, body);
    }

    private void addRecipients(AddressList addressList) {
        for (String address : nonSwitchArgument(0).split(",")) {
            addressList.addRecipient(new Address(address));
        }
    }

    public Format parseFormat() {
        if (hasChatSwitch()) return new ChatFormat();
        return new MailFormat();
    }

    private boolean hasChatSwitch() {
        return arguments.get(0).equals("-im");
    }

    private String nonSwitchArgument(int number) {
        return allNonSwitchArguments().get(number);
    }

    private List<String> allNonSwitchArguments() {
        int first = hasChatSwitch() ? 1 : 0;
        return arguments.subList(first, arguments.size());
    }
}
