package net.m14m.katas.messaging.mailer;

import net.m14m.katas.messaging.Mailer;
import net.m14m.katas.messaging.message.Message;

import java.util.*;

public class Environment {
    private Map<Format, Mailer> mailers = new EnumMap<Format, Mailer>(Format.class);

    public void registerMailer(Format format, ValidatingMailer mailer) {
        mailers.put(format, mailer);
    }

    public void send(Format format, Message message) {
        Mailer mailer = mailers.get(format);
        message.sendThrough(mailer);
    }
}
