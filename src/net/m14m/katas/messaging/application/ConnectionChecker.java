package net.m14m.katas.messaging.application;

import java.io.PrintWriter;

class ConnectionChecker {
    private PrintWriter network;

    public ConnectionChecker(PrintWriter network) {
        this.network = network;
    }

    public void reportProblemsTo(PrintWriter console) {
        if (network.checkError()) {
            console.println("Connection error. Please try again.");
        }
    }
}
