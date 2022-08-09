package ru.aberezhnoy;

import ru.aberezhnoy.service.FileService;
import ru.aberezhnoy.service.SocketService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ArchitecturalWebServer {

    private static String WWW = "/Users/alex/Documents/Study/Portfolio/architecture/www";

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8088)) {
            System.out.println("Server started");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                new Thread(new RequestHandler(new SocketService(socket), new FileService(WWW, "index.html"))).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
