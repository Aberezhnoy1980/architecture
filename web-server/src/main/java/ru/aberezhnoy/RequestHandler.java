package ru.aberezhnoy;

import ru.aberezhnoy.service.FileService;
import ru.aberezhnoy.service.SocketService;

import java.io.IOException;
import java.util.Deque;

public class RequestHandler implements Runnable {

    private final SocketService socketService;

    private final FileService fileService;

    public RequestHandler(SocketService socketService, FileService fileService) {
        this.socketService = socketService;
        this.fileService = fileService;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        String firstLine = rawRequest.pollFirst();
        String[] parts = firstLine.split(" ");

        if (!fileService.exists(parts[1])) {
            String rawResponse = "HTTP/1.1 404 NOT FOUND\n" +
                    "Content-type: text/html; charset=utf-8\n" +
                    "\n" +
                    "<h2>File not found!<h2>";
            socketService.writeResponse(rawResponse);
            return;
        } else if (fileService.isDirectory(parts[1])) {
            String rawResponse = "HTTP/1.1 500 INTERNAL SERVER ERROR\n" +
                    "Content-type: text/html; charset=utf-8\n" +
                    "\n" +
                    "<H2>" + fileService.readFile(parts[1]) + "<H2>";
            socketService.writeResponse(rawResponse);
            return;
        } else {
            String rawResponse = "HTTP/1.1 200 OK\n" +
                    "Content-type: text/html; charset=utf-8\n" +
                    "\n" +
                    fileService.readFile(parts[1]);
            socketService.writeResponse(rawResponse);
        }

        try {
            socketService.close();
        } catch (IOException exception) {
            throw new IllegalStateException(exception);
        }
        System.out.println("Client disconnected");
    }
}

