package net.m14m.katas.messaging_endtoendtest;

import net.m14m.katas.messaging.Main;
import org.junit.*;

import java.io.*;

import static org.hamcrest.CoreMatchers.*;
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

    @Ignore @Test public void sendAnEmail_AnotherExample() {
        Main.main("sally@example.com", "Greetings.\nHow's it going?");
        networkShouldReceive("connect smtp\n" +
                "To: sally@example.com\n" +
                "\n" +
                "Greetings.\n" +
                "How's it going?\n" +
                "\n" +
                "disconnect\n");
        consoleShouldReceive(NO_OUTPUT);
    }

    @Ignore @Test public void showAnErrorAndDoNotSendIfTheEmailAddressIsInvalid() {
        Main.main("no at sign", "Hi there!");
        networkShouldReceive(NO_OUTPUT);
        consoleShouldReceive("Invalid email address: no at sign\n");
    }

    @Ignore @Test public void showAnErrorAndDoNotSendIfTheBodyIsInvalid() {
        Main.main("dinah@example.com", "");
        networkShouldReceive(NO_OUTPUT);
        consoleShouldReceive("Cannot send an email with no body.\n");
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

    @Ignore @Test public void handleErrorsGracefully() {
        Main.setNetwork(new BadNetworkConnection());
        Main.main("joe@example.com", "Hi there!");
        consoleShouldReceive("Connection error. Please try again.\n");
    }

    @Ignore @Test public void chatsToMultipleAddressesGetSentIndividually() {
        Main.main("-im", "leslie@chat.example.com,joey@chat.example.com", "Hello.");
        networkShouldReceive("connect chat\n" +
                "<leslie@chat.example.com>(Hello.)\n" +
                "<joey@chat.example.com>(Hello.)\n" +
                "disconnect\n");
        consoleShouldReceive(NO_OUTPUT);
    }

    private void networkShouldReceive(String output) {
        assertThat(network.toString(), equalTo(output));
    }

    private void consoleShouldReceive(String output) {
        assertThat(console.toString(), equalTo(output));
    }

    private static class BadNetworkConnection extends Writer {
        @Override public void write(char[] cbuf, int off, int len) throws IOException {
            throw new IOException("Oh no the network is down!!!!!!!111one");
        }

        @Override public void flush() throws IOException {
        }

        @Override public void close() throws IOException {
        }
    }
}
