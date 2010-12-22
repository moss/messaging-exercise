package net.m14m.katas.messaging;

import org.junit.*;

import static org.junit.Assert.*;

public class ToAddressTest {
    private ErrorHandlerSpy handler = new ErrorHandlerSpy();

    @Test public void validIfItHasAnAtSign() {
        new ToAddress("joe@example.com").reportProblems(handler);
        handler.shouldBeValid();
    }

    @Test public void invalidIfItHasNoAtSign() {
        new ToAddress("!").reportProblems(handler);
        handler.shouldBeInvalid();
    }

    private static class ErrorHandlerSpy implements ErrorHandler {
        private boolean valid = true;

        public void error() {
            valid = false;
        }

        private void shouldBeValid() {
            assertTrue(valid);
        }

        private void shouldBeInvalid() {
            assertFalse(valid);
        }
    }
}
