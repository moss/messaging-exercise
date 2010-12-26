package net.m14m.katas.messaging.mailer;

import net.m14m.katas.messaging.ToAddressFormatter;
import net.m14m.katas.messaging.message.IndividualToAddress;

import java.io.PrintWriter;

public class SmtpToAddressFormatter implements ToAddressFormatter {
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
