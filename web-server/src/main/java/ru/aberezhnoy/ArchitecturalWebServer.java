package ru.aberezhnoy;

import ru.aberezhnoy.config.ServerConfig;
import ru.aberezhnoy.factory.*;
import ru.aberezhnoy.handler.RequestHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ArchitecturalWebServer {

    public static void main(String[] args) {
//        ServerConfig config = WebServerFactory.createServerConfig(args);
        ServerConfig config = ServerConfigFactory.create(args);
        try (ServerSocket serverSocket = new ServerSocket(config.getPort())) {
            System.out.println("Server started");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                new Thread(new RequestHandler(
//                        WebServerFactory.createSocketService(socket),
//                        WebServerFactory.createFileService(config.getUrlHome()),
//                        WebServerFactory.createRequestParser(),
//                        WebServerFactory.createResponseSerializer()
                        SocketServiceFactory.create(socket),
                        FileServiceFactory.create(config.getUrlHome()),
                        RequestParserFactory.create(),
                        ResponseSerializerFactory.create()
                )).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
