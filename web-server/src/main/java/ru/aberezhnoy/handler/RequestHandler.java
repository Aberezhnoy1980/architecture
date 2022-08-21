package ru.aberezhnoy;

import ru.aberezhnoy.domain.HttpRequest;
import ru.aberezhnoy.domain.HttpResponse;
import ru.aberezhnoy.domain.HttpResponseCode;
import ru.aberezhnoy.service.FileService;
import ru.aberezhnoy.service.SocketService;

import java.io.IOException;
import java.util.Deque;

public class RequestHandler implements Runnable {

    private final SocketService socketService;

    private final FileService fileService;

    private final RequestParser requestParser;

    private final ResponseSerializer responseSerializer;

    public RequestHandler(SocketService socketService, FileService fileService, RequestParser requestParser, ResponseSerializer responseSerializer) {
        this.socketService = socketService;
        this.fileService = fileService;
        this.requestParser = requestParser;
        this.responseSerializer = responseSerializer;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest httpRequest = requestParser.parseRequest(rawRequest);

        if (!fileService.exists(httpRequest.getUrl())) {
            socketService
                    .writeResponse(responseSerializer
                            .serializeResponse(HttpResponse
                                    .createBuilder()
                                    .setStatus(HttpResponseCode.NOT_FOUND)
                                    .setHeaders("Content-Type", "text/html; charset=utf-8")
                                    .setBody("<H2>File not found!<H2>")
                                    .build()));
            return;
        } else if (fileService.isDirectory(httpRequest.getUrl())) {
            socketService
                    .writeResponse(responseSerializer
                            .serializeResponse(HttpResponse
                                    .createBuilder()
                                    .setStatus(HttpResponseCode.BAD_REQUEST)
                                    .setHeaders("Content-Type", "text/html; charset=utf-8")
                                    .setBody("<H2>" + fileService.readFile(httpRequest.getUrl()) + "<H2>")
                                    .build()));
            return;
        } else {
            socketService
                    .writeResponse(responseSerializer
                            .serializeResponse(HttpResponse
                                    .createBuilder()
                                    .setStatus(HttpResponseCode.OK)
                                    .setHeaders("Content-Type", "text/html; charset=utf-8")
                                    .setBody("<H2>" + fileService.readFile(httpRequest.getUrl()) + "<H2>")
                                    .build()));
        }

        try {
            socketService.close();
        } catch (IOException exception) {
            throw new IllegalStateException(exception);
        }
        System.out.println("Client disconnected");
    }
}

