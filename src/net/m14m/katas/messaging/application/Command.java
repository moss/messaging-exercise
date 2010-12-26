package net.m14m.katas.messaging.application;

import net.m14m.katas.messaging.mailer.*;
import net.m14m.katas.messaging.message.*;

public class Command {
    int position = 0;
    private String[] args;

    public Command(String... args) {
        this.args = args;
    }

    public void runIn(Environment environment) {
        Format format = parseFormat();
        ToAddressBlock to = ToAddressBlock.parseCommaSeparated(nextArg());
        Body body = new Body(nextArg());
        environment.send(format, new Message(to, body));
    }

    private Format parseFormat() {
        if (peek().equals("-im")) {
            advance();
            return Format.chat;
        }
        return Format.smtp;
    }

    private String nextArg() {
        String value = peek();
        advance();
        return value;
    }

    private String peek() {
        return args[position];
    }

    private void advance() {
        position++;
    }
}
