package ru.aberezhnoy.handler;

import ru.aberezhnoy.domain.HttpRequest;
import ru.aberezhnoy.domain.HttpResponse;
import ru.aberezhnoy.domain.HttpResponseCode;
import ru.aberezhnoy.domain.HttpResponseMethod;
import ru.aberezhnoy.service.FileService;
import ru.aberezhnoy.service.ResponseSerializer;
import ru.aberezhnoy.service.SocketService;

@Handler(order = 1)
class PostMethodHandler extends MethodHandlerImpl {

    private final String headerKey = "Content-Type";
    private final String headerValue = "charset=utf-8";
    private final String body = "<H2>File not found!<H2>";

    public PostMethodHandler(MethodHandler next, SocketService socketService, ResponseSerializer responseSerializer, FileService fileService) {
        super(String.valueOf(HttpResponseMethod.POST), next, socketService, responseSerializer);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        return HttpResponse.createBuilder()
                .setStatus(HttpResponseCode.OK)
                .setHeaders(headerKey, headerValue)
                .setBody(body)
                .build();
    }
}

