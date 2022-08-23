package ru.aberezhnoy.adapter;

public class AdapterApp {

    public static void main(String[] args) {

        WildDog wildDog = new WildDog();
        WildDogAdapter wildDogAdapter = new WildDogAdapter(wildDog);

        Hunter hunter = new Hunter();

        Lion africanLion = new AfricanLion();
        Lion asianLion = new AsianLion();
        Cat cat = new Cat();

        hunter.hunt(wildDogAdapter);
        hunter.hunt(africanLion);
        hunter.hunt(asianLion);
        hunter.hunt(cat); // I have just overridden the method in the class. Why not do this, if you do not take into account the stupidity?
    }
}
