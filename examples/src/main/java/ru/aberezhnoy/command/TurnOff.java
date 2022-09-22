package ru.aberezhnoy.command;

// Command
public class TurnOff implements Command {

    private final Bulb bulb;

    public TurnOff(Bulb bulb) {
        this.bulb = bulb;
    }

    @Override
    public void execute() {
        this.bulb.turnOff();
    }

    @Override
    public void undo() {
        this.bulb.turnOn();
    }

    @Override
    public void redo() {
        this.execute();
    }
}
