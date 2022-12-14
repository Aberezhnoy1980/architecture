package ru.aberezhnoy.config;

import ru.aberezhnoy.config.ConfigFromCli;
import ru.aberezhnoy.config.ConfigFromFile;
import ru.aberezhnoy.config.ConfigFromFixedValue;
import ru.aberezhnoy.config.ServerConfig;

import java.nio.file.Files;
import java.nio.file.Path;

public final class ServerConfigFactory {
    public static ServerConfig create(String[] args) {
        if (args.length >= 2) {
            return new ConfigFromCli(args);
        } else if (Files.exists(Path.of("../../../server.properties"))) {
            return new ConfigFromFile("../../../server.properties");
        } else {
            return new ConfigFromFixedValue();
        }
    }
}
