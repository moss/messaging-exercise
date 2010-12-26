package net.m14m.katas.messaging.message;

import java.io.PrintWriter;

public class SmtpToAddressFormatter {
    private PrintWriter network;

    public SmtpToAddressFormatter(PrintWriter network) {
        this.network = network;
    }

    public void append(IndividualToAddress address) {
        network.write("To: ");
        address.appendTo(network);
        network.println();
    }
}
