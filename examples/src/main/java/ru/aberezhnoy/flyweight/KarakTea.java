package ru.aberezhnoy.flyweight;

public class KarakTea implements Tea {

    private String name;

    public KarakTea(String name) {
        this.name = name;
    }

    @Override
    public void drink() {
        System.out.println("you drink karak tea");
    }

    @Override
    public String toString() {
        return name;
    }
}
