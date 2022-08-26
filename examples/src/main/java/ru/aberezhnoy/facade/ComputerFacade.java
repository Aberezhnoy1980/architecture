package ru.aberezhnoy.facade;

public class ComputerFacade {

    private Computer computer;

    public ComputerFacade(Computer computer) {
        this.computer = computer;
    }

    public static ComputerFacade createFacade(Computer computer) {
        return new ComputerFacade(computer);
    }

    public void turnOn() {
        this.computer.getElectricShock();
        this.computer.makeSound();
        this.computer.showLoadingScreen();
        this.computer.bam();
    }

    public void turnOff() {
        this.computer.closeEverything();
        this.computer.pullCurrent();
        this.computer.sooth();
    }
}
