package net.m14m.katas.messaging;

public interface Mailer {
    void send(ToAddress to, Body body);
}
