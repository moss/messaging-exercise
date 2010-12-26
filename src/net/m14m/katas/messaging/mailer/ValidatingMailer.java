package net.m14m.katas.messaging.mailer;

import net.m14m.katas.messaging.Error;
import net.m14m.katas.messaging.*;
import net.m14m.katas.messaging.message.*;

import java.io.PrintWriter;

public class ValidatingMailer implements Mailer, ErrorHandler {
    private Mailer mailer;
    private final PrintWriter console;

    public ValidatingMailer(Mailer mailer, PrintWriter console) {
        this.mailer = mailer;
        this.console = console;
    }

    public void send(ToAddressBlock to, Body body) {
        to.reportProblems(this);
        body.reportProblems(this);
        mailer.send(to, body);
    }

    public void error(Error error) {
        this.mailer = new NoOpMailer();
        error.writeTo(console);
    }

    private static class NoOpMailer implements Mailer {
        public void send(ToAddressBlock to, Body body) {
        }
    }
}
