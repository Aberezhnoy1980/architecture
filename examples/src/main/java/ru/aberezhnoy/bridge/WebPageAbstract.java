package ru.aberezhnoy.bridge;

// I couldn't find another way to avoid constructor declaration in interface
public abstract class WebPageAbstract {

    Theme theme;

    WebPageAbstract(Theme theme) {
        this.theme = theme;
    }
}
