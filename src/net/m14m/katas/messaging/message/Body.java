package net.m14m.katas.messaging.message;

import net.m14m.katas.messaging.*;

import java.io.PrintWriter;

public class Body {
    private final String body;

    public Body(String body) {
        this.body = body;
    }

    public void writeTo(PrintWriter network) {
        network.print(body);
    }

    public void writeEscapingParentheses(PrintWriter network) {
        network.print(body.replace(")", "\\)"));
    }

    public void reportProblems(ErrorHandler handler) {
        if (body.isEmpty()) {
            handler.error(new ValidationError("Cannot send an email with no body."));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Body that = (Body) o;
        return body.equals(that.body);
    }

    @Override
    public int hashCode() {
        return body.hashCode();
    }
}
