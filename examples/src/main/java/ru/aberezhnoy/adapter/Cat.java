package ru.aberezhnoy.adapter;

public class Cat implements Lion {

    @Override
    public void roar() {
        System.out.println("meow, meow, meow");
    }
}
