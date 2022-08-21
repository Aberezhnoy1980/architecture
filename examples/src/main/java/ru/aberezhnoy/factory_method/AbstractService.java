package ru.aberezhnoy.factory_method;

public abstract class AbstractService {

    public void doSomething() {
        SomeInterface someInterface = create();
        someInterface.something();
    }

    public abstract SomeInterface create();
}
