package ru.aberezhnoy.visitor;

public interface Animal {
    void accept(AnimalOperation operation);
}
