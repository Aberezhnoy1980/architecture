package ru.aberezhnoy.command;

// Invoker
public class RemoteControl {

    public void submit(Command command) {
        command.execute();
    }
}
