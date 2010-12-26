package net.m14m.katas.messaging;

public interface Mailer {
    void send(ToAddressBlock to, Body body);
}
