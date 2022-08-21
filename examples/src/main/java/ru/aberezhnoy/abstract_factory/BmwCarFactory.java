package ru.aberezhnoy.abstract_factory;

public class BmwCarFactory implements CarFactory {
    @Override
    public String createSedan() {
        return "MW Sedan";
    }

    @Override
    public String createHatchback() {
        return "BMW Hatchback";
    }

    @Override
    public String createUniversal() {
        return "BMW Universal";
    }
}
