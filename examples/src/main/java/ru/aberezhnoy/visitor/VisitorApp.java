package ru.aberezhnoy.visitor;

public class VisitorApp {
    public static void main(String[] args) {
        Monkey monkey = new Monkey();
        Lion lion = new Lion();
        Dolphin dolphin = new Dolphin();

        Speak speak = new Speak();

        monkey.accept(speak);
        lion.accept(speak);
        dolphin.accept(speak);
    }
}
