package ru.aberezhnoy.factory;

import ru.aberezhnoy.config.ConfigFromCli;
import ru.aberezhnoy.config.ConfigFromFile;
import ru.aberezhnoy.config.ConfigFromFixedValue;
import ru.aberezhnoy.config.ServerConfig;
import ru.aberezhnoy.service.*;

import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public final class WebServerFactory {
    public static ServerConfig createServerConfig(String[] args) {
        if (args.length >= 2) {
            return new ConfigFromCli(args);
        } else if (Files.exists(Path.of("../../../server.properties"))) {
            return new ConfigFromFile("../../../server.properties");
        } else {
            return new ConfigFromFixedValue();
        }
    }

    public static FileService createFileService(String rootDir) {
        return new FileServiceImpl(rootDir);
    }

    public static SocketService createSocketService(Socket socket) {
        return new SocketServiceImpl(socket);
    }

    public static RequestParser createRequestParser() {
        return new RequestParserImpl();
    }

    public static ResponseSerializer createResponseSerializer() {
        return new ResponseSerializerImpl();
    }
}