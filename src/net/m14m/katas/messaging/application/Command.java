package net.m14m.katas.messaging.application;

import net.m14m.katas.messaging.mailer.Environment;
import net.m14m.katas.messaging.message.*;

public class Command {
    private String[] args;

    public Command(String... args) {
        this.args = args;
    }

    public void runIn(Environment environment) {
        ToAddressBlock to = ToAddressBlock.parseCommaSeparated(args[0]);
        Body body = new Body(args[1]);
        environment.send(to, body);
    }
}
