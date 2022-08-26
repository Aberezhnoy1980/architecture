package ru.aberezhnoy.handler;

import ru.aberezhnoy.config.ServerConfig;
import ru.aberezhnoy.domain.HttpRequest;
import ru.aberezhnoy.domain.HttpResponse;
import ru.aberezhnoy.domain.HttpResponseCode;
import ru.aberezhnoy.service.ResponseSerializer;
import ru.aberezhnoy.service.SocketService;

abstract class MethodHandlerImpl implements MethodHandler {

    private final String method;

    private final MethodHandlerImpl next;

    protected final SocketService socketService;

    protected final ResponseSerializer responseSerializer;

    protected final ServerConfig config;

    public MethodHandlerImpl(String method,
                             MethodHandlerImpl next,
                             SocketService socketService,
                             ResponseSerializer responseSerializer,
                             ServerConfig config) {
        this.method = method;
        this.next = next;
        this.socketService = socketService;
        this.responseSerializer = responseSerializer;
        this.config = config;
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
                    .setHeaders("Content-Type", "text/html; charset=utf-8")
                    .setBody("<H2>Method not allowed!")
                    .build();
        }
        String rawResponse = responseSerializer.serializeResponse(response);
        socketService.writeResponse(rawResponse);
    }

    protected abstract HttpResponse handleInternal(HttpRequest request);
}
