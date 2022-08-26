package ru.aberezhnoy.config;

import java.io.IOException;
import java.util.Properties;

class ConfigFromFile implements ServerConfig {

    private final int port;

    private final String urlHome;

    public ConfigFromFile(String fileName) {
        System.out.println("Getting config from config file");
        Properties prop = new Properties();
        try {
            prop.load(getClass().getResourceAsStream(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.port = Integer.parseInt(prop.getProperty("port"));
        this.urlHome = prop.getProperty("urlHome");
    }

    @Override
    public int getPort() {
        return this.port;
    }

    @Override
    public String getUrlHome() {
        return this.urlHome;
    }
}
