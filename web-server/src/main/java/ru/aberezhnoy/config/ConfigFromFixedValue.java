package ru.aberezhnoy.config;

class ConfigFromFixedValue implements ServerConfig {

    private static final String DEFAULT_WWW_PATH = "/Users/alex/Documents/Study/Portfolio/architecture/www";

    private static final int DEFAULT_PORT = 8088;

    @Override
    public String getUrlHome() {
        return DEFAULT_WWW_PATH;
    }

    @Override
    public int getPort() {
        return DEFAULT_PORT;
    }
}
