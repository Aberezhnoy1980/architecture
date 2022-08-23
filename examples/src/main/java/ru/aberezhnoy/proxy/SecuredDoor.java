package ru.aberezhnoy.proxy;

import java.util.Objects;

public class SecuredDoor {

    private Door door;

    public SecuredDoor(Door door) {
        this.door = door;
    }

    public void open(String password) {

        if (this.authenticate(password)) {
            this.door.open();
        } else {
            System.out.println("Big no! It ain't possible.");
        }
    }

    public boolean authenticate(String password) {
        return Objects.equals(password, "$ecr@t");
    }

    public void close() {
        this.door.close();
    }
}
