package net.m14m.katas.messaging;

import java.util.List;

public interface Sender {
    void send(List<Address> addresses, Body body);
}
