package ru.aberezhnoy.template_method;

public class TemplateMethodApp {
    public static void main(String[] args) {
        AndroidBuilder androidBuilder = new AndroidBuilder();
        androidBuilder.build();

        IosBuilder iosBuilder = new IosBuilder();
        iosBuilder.build();
    }
}
