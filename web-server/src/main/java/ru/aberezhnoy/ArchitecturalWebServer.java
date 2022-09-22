package ru.aberezhnoy;

import ru.aberezhnoy.config.ServerConfig;
import ru.aberezhnoy.config.ServerConfigFactory;
import ru.aberezhnoy.handler.AnnotatedMethodHandlerFactory;
import ru.aberezhnoy.handler.MethodHandlerFactory;
import ru.aberezhnoy.handler.RequestHandler;
import ru.aberezhnoy.service.*;

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

                SocketService socketService = SocketServiceFactory.create(socket);

                new Thread(new RequestHandler(
                        socketService,
                        RequestParserFactory.create(),
                        AnnotatedMethodHandlerFactory.create(socketService,
                                ResponseSerializerFactory.create(),
                                FileServiceFactory.create(config.getUrlHome()))
                )).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
