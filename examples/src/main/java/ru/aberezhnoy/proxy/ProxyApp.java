package ru.aberezhnoy.proxy;

public class ProxyApp {
    public static void main(String[] args) {

        var door = new SecuredDoor(new LabDoor());

        door.open("invalid"); // Big no! It ain't possible.

        door.open("$ecr@t"); // Opening door
        door.close(); // Closing lab door
    }
}
