package net.m14m.katas.messaging.application;

import net.m14m.katas.messaging.errors.ErrorBroadcaster;
import net.m14m.katas.messaging.message.Message;
import net.m14m.katas.messaging.network.*;

class Application {
    private Sender sender;
    private ErrorBroadcaster errorBroadcaster;

    public Application(Sender sender, ErrorBroadcaster errorBroadcaster) {
        this.sender = sender;
        this.errorBroadcaster = errorBroadcaster;
    }

    public void execute(CommandLine commandLine) {
        Message message = commandLine.parseMessage();
        message.validate(errorBroadcaster);
        Envelope envelope = new Envelope(message, commandLine.parseFormat());
        sender.sendMail(envelope);
    }
}
