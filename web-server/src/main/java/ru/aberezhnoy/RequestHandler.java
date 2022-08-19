package ru.aberezhnoy;

import ru.aberezhnoy.domain.HttpRequest;
import ru.aberezhnoy.domain.HttpResponse;
import ru.aberezhnoy.domain.HttpResponseCode;
import ru.aberezhnoy.service.FileService;
import ru.aberezhnoy.service.RequestParser;
import ru.aberezhnoy.service.ResponseSerializer;
import ru.aberezhnoy.service.SocketService;

import java.io.IOException;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

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

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-type", "text/html; charset=utf-8");

        if (!fileService.exists(httpRequest.getUrl())) {
            HttpResponse httpResponse = new HttpResponse(
                    HttpResponseCode.NOT_FOUND,
                    headers,
                    "<h2>File not found!<h2>");
            socketService.writeResponse(responseSerializer.serializeResponse(httpResponse));
            return;
        } else if (fileService.isDirectory(httpRequest.getUrl())) {
            HttpResponse httpResponse = new HttpResponse(
                    HttpResponseCode.BAD_REQUEST,
                    headers,
                    "<H2>" + fileService.readFile(httpRequest.getUrl()) + "<H2>");
            socketService.writeResponse(responseSerializer.serializeResponse(httpResponse));
            return;
        } else {
            HttpResponse httpResponse = new HttpResponse(
                    HttpResponseCode.OK,
                    headers,
                    "<H2>" + fileService.readFile(httpRequest.getUrl()) + "<H2>");
            socketService.writeResponse(responseSerializer.serializeResponse(httpResponse));
        }

        try {
            socketService.close();
        } catch (IOException exception) {
            throw new IllegalStateException(exception);
        }
        System.out.println("Client disconnected");
    }
}

