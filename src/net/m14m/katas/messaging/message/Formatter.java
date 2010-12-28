package net.m14m.katas.messaging.message;

public interface Formatter {
    String format(AddressList addressList, Body body);
}
