package ru.aberezhnoy.handler;

import ru.aberezhnoy.service.RequestParser;
import ru.aberezhnoy.service.ResponseSerializer;
import ru.aberezhnoy.domain.HttpRequest;
import ru.aberezhnoy.domain.HttpResponse;
import ru.aberezhnoy.domain.HttpResponseCode;
import ru.aberezhnoy.service.FileService;
import ru.aberezhnoy.service.SocketService;

import java.io.IOException;
import java.util.Deque;

public class RequestHandler implements Runnable {

    private final SocketService socketService;

    private final RequestParser requestParser;

    private final MethodHandler methodHandler;

    public RequestHandler(SocketService socketService, RequestParser requestParser, MethodHandler methodHandler) {
        this.socketService = socketService;
        this.requestParser = requestParser;
        this.methodHandler = methodHandler;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest httpRequest = requestParser.parseRequest(rawRequest);

        methodHandler.handle(httpRequest);
        try {
            socketService.close();
        } catch (IOException exception) {
            throw new IllegalStateException(exception);
        }
        System.out.println("Client disconnected");
    }
}

