package ru.aberezhnoy.bridge;

public class ThemeFactory {

    public static Theme creatDarkTheme() {
        return new DarkTheme();
    }

    public static Theme creatLightTheme() {
        return new LightTheme();
    }

    public static Theme creatAquaTheme() {
        return new AquaTheme();
    }
}
