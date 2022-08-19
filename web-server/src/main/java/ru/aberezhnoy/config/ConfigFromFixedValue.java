package ru.aberezhnoy.config;

public class ConfigFromFixedValue implements ServerConfig {

    @Override
    public String getUrlHome() {
        return "/Users/alex/Documents/Study/Portfolio/architecture/www";
    }

    @Override
    public int getPort() {
        return 8088;
    }
}
