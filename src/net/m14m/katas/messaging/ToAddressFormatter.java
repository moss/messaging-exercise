package net.m14m.katas.messaging;

import net.m14m.katas.messaging.message.IndividualToAddress;

public interface ToAddressFormatter {
    void append(IndividualToAddress address);
}
