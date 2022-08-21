package ru.aberezhnoy.factory_method;

public class ConcreteService extends AbstractService {

    @Override
    public SomeInterface create() {
        return new SomeInterface() {
            @Override
            public void something() {
                System.out.println("Something 1");
            }
        };
    }
}
