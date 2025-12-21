package org.dontpanic.ysoserial.simple;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class CommandRunner implements Serializable {

    private Runnable command;

    public CommandRunner(String command) {
        this.command = new SerializableRunner(command);
    }

    private final void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        command.run();
    }

    private static class SerializableRunner implements Runnable, Serializable {
        private final String command;
        public SerializableRunner(String command) {
            this.command = command;
        }
        @Override
        public void run() {
            try {
                System.out.println("Executing command: " + command);
                Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
