package ru.aberezhnoy.handler;

import ru.aberezhnoy.domain.HttpRequest;
import ru.aberezhnoy.domain.HttpResponse;
import ru.aberezhnoy.domain.HttpResponseCode;
import ru.aberezhnoy.service.FileService;
import ru.aberezhnoy.service.ResponseSerializer;
import ru.aberezhnoy.service.SocketService;

abstract class MethodHandlerImpl implements MethodHandler {

    private static final String header = "Content-Type, text/html; charset=utf-8";
    private String headerKey = "Content-Type";
    private final String headerValue = "charset=utf-8";
    private final String body = "<H2>File not found!<H2>";

    protected final SocketService socketService;
    protected final ResponseSerializer responseSerializer;
    private final String method;
    private final MethodHandler next;

    public MethodHandlerImpl(String method,
                             MethodHandler next,
                             SocketService socketService,
                             ResponseSerializer responseSerializer) {
        this.method = method;
        this.next = next;
        this.socketService = socketService;
        this.responseSerializer = responseSerializer;
        this.headerKey = "Content-Type";
        final String headerValue = "charset=utf-8";
        final String body = "<H2>File not found!<H2>";
    }

    @Override
    public void handle(HttpRequest request) {
        HttpResponse response;
        if (method.equals(request.getMethod())) {
            response = handleInternal(request);
        } else if (next != null) {
            next.handle(request);
            return;
        } else {
            response = HttpResponse.createBuilder()
                    .setStatus(HttpResponseCode.METHOD_NOT_ALLOWED)
                    .setHeaders(headerValue, body)
                    .setBody("<H2>Method not allowed!")
                    .build();
        }
        String rawResponse = responseSerializer.serializeResponse(response);
        socketService.writeResponse(rawResponse);
    }

    protected abstract HttpResponse handleInternal(HttpRequest request);
}
