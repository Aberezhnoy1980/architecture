package ru.aberezhnoy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RequestHandler implements Runnable {

    private final Socket socket;

    private final String folder;

    public RequestHandler(Socket socket, String folder) {
        this.socket = socket;
        this.folder = folder;
    }

    @Override
    public void run() {
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

            Path path = Paths.get(folder, parts[1]);
            if (!Files.exists(path)) {
                output.println("HTTP/1.1 404 NOT FOUND");
                output.println("Content-type: text/html; charset=utf-8");
                output.println();
                output.println("<h1>File not found!<h1>");
                output.flush();
                return;
            }

            output.println("HTTP/1.1 200 OK");
            output.println("Content-type: text/html; charset=utf-8");
            output.println();


            Files.newBufferedReader(path).transferTo(output);

            System.out.println("Client disconnected");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}