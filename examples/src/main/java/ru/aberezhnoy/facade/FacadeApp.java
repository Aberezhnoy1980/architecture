package ru.aberezhnoy.facade;

public class FacadeApp {

    public static void main(String[] args) {

        ComputerFacade computer = ComputerFacade
                .createFacade(Computer
                        .newComputer());

        computer.turnOn(); // Ouch! Beep beep! Loading.. Ready to be used!
        computer.turnOff(); // Bup bup buzzz! Haah! Zzzzz
    }
}
