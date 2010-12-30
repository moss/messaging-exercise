package net.m14m.katas.messaging;

import java.io.PrintWriter;
import java.util.List;

import static java.util.Arrays.asList;

public class CommandLine {
    private List<String> args;

    public CommandLine(String... args) {
        this.args = asList(args);
    }

    public Sender createSender(PrintWriter output) {
        if (chatSwitchSet()) return new ChatSender(output);
        return new MailSender(output);
    }

    public List<Address> getAddresses() {
        return Address.listFrom(nonSwitchArgument(0));
    }

    public Body getBody() {
        return new Body(nonSwitchArgument(1));
    }

    private String nonSwitchArgument(int index) {
        if (chatSwitchSet()) index++;
        return args.get(index);
    }

    private boolean chatSwitchSet() {
        return args.get(0).equals("-im");
    }
}
