package net.m14m.katas.messaging.message;

public interface Format {
    String format(AddressList addressList, Body body);
}
