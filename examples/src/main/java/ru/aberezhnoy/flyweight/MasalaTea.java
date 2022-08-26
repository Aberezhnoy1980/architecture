package ru.aberezhnoy.flyweight;

public class MasalaTea implements Tea {

    private String name;

    public MasalaTea(String name) {
        this.name = name;
    }

    @Override
    public void drink() {
        System.out.println("you drink masala tea");
    }

    @Override
    public String toString() {
        return name;
    }
}
