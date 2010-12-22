package net.m14m.katas.messaging;

import org.junit.*;

import java.io.StringWriter;

import static org.junit.Assert.*;

public class EndToEndTest {
    private static final String NO_OUTPUT = "";
    private StringWriter network = new StringWriter();
    private StringWriter console = new StringWriter();

    @Before public void configureMainClassWithFakeOutputs() {
        Main.setNetwork(network);
        Main.setConsole(console);
    }

    @Test public void sendAnEmail() {
        Main.main("joe@example.com", "Hi there!");
        networkShouldReceive("connect smtp\n" +
                "To: joe@example.com\n" +
                "\n" +
                "Hi there!\n" +
                "\n" +
                "disconnect\n");
        consoleShouldReceive(NO_OUTPUT);
    }

    @Ignore @Test public void showAnErrorAndDoNotSendIfTheEmailAddressIsInvalid() {
        Main.main("no at sign", "Hi there!");
        networkShouldReceive(NO_OUTPUT);
        consoleShouldReceive("Invalid email address: no at sign");
    }

    @Ignore @Test public void sendAnEmailToMultipleAddresses() {
        Main.main("sally@example.com,joe@example.com", "Hi everyone!");
        networkShouldReceive("connect smtp\n" +
                "To: sally@example.com\n" +
                "To: joe@example.com\n" +
                "\n" +
                "Hi everyone!\n" +
                "\n" +
                "disconnect\n");
        consoleShouldReceive(NO_OUTPUT);
    }

    @Ignore @Test public void sendAMessageInAnotherFormat() {
        Main.main("-im", "leslie@chat.example.com", ":-) hey there!");
        networkShouldReceive("connect chat\n" +
                "<leslie@chat.example.com>(:-\\) hey there!)\n" +
                "disconnect\n");
        consoleShouldReceive(NO_OUTPUT);
    }

    private void networkShouldReceive(String output) {
        assertEquals(output, network.toString());
    }

    private void consoleShouldReceive(String output) {
        assertEquals(output, console.toString());
    }
}
