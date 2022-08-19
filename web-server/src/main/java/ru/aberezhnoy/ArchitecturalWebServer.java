package ru.aberezhnoy;

import ru.aberezhnoy.config.ServerConfig;
import ru.aberezhnoy.config.ConfigFromFile;
import ru.aberezhnoy.config.ServerConfigFactory;
import ru.aberezhnoy.service.FileService;
import ru.aberezhnoy.service.RequestParser;
import ru.aberezhnoy.service.ResponseSerializer;
import ru.aberezhnoy.service.SocketService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ArchitecturalWebServer {

    public static void main(String[] args) {
        ServerConfig config = ServerConfigFactory.create(args);
        try (ServerSocket serverSocket = new ServerSocket(config.getPort())) {
            System.out.println("Server started");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                new Thread(new RequestHandler(
                        new SocketService(socket),
                        new FileService(config.getUrlHome()),
                        new RequestParser(),
                        new ResponseSerializer()
                )).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
