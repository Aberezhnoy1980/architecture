package ru.aberezhnoy.service;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketService implements Closeable {

    private final Socket socket;

    public SocketService(Socket socket) {
        this.socket = socket;
    }

    public String readRequest() {
        try (BufferedReader input = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream(), StandardCharsets.UTF_8));
        ) {
            while (!input.ready()) ;

            String firstLine = input.readLine();
//            String[] parts = firstLine.split(" ");
            System.out.println(firstLine);
            while (input.ready()) {
                System.out.println(input.readLine());
            }
            return input.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return toString();
    }

    public void writeResponse(String response) {
        try {
            PrintWriter output = new PrintWriter(socket.getOutputStream());
            output.print(response);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {
        if (!socket.isClosed()) {
            socket.close();
        }
    }
}
