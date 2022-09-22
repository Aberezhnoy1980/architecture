package ru.aberezhnoy.command;

public interface Command {
    void execute();

    void undo();

    void redo();
}
