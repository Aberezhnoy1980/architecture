package ru.aberezhnoy.command;

public class CommandApp {
    public static void main(String[] Args) {
        var bulb = new Bulb();

        var turnOn = new TurnOn(bulb);
        var turnOff = new TurnOff(bulb);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.submit(turnOn); // Bulb has been lit!
        remoteControl.submit(turnOff); // Darkness!
    }
}
