package ru.aberezhnoy.initial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InitialWebServer {

    private static String WWW = "/Users/alex/Documents/Study/Portfolio/architecture/www";

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8089)) {
            System.out.println("Server started");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                new Thread(() -> handlerRequest(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handlerRequest(Socket socket) {
        try (BufferedReader input = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter output = new PrintWriter(socket.getOutputStream())
        ) {
            while (!input.ready()) ;

            String firstLine = input.readLine();
            String[] parts = firstLine.split(" ");
            System.out.println(firstLine);
            while (input.ready()) {
                System.out.println(input.readLine());
            }

            Path path = Paths.get(WWW, parts[1]);
            if (!Files.exists(path)) {
                output.println("HTTP/1.1 404 NOT FOUND");
                output.println("Content-type: text/html; charset=utf-8");
                output.println();
                output.println("<h1>File not found!!!<h1>");
                output.flush();
                return;
            }

            output.println("HTTP/1.1 200 OK");
            output.println("Content-type: text/html; charset=utf-8");
            output.println();

//            try {
                Files.newBufferedReader(path).transferTo(output); // TODO try to catch exception with Files.isDirectory maybe
//            } catch (Exception ex) {
//                output.println("HTTP/1.1 500 BAD REQUEST");
//                output.println("Content-type: text/html; charset=utf-8");
//                output.println();
//                output.println("<h1>" + ex.getMessage() +"<h1>");
//                output.flush();
//            }

            System.out.println("Client disconnected");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
