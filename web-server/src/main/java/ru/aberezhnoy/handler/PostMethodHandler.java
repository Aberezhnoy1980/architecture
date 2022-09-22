package ru.aberezhnoy.handler;

import ru.aberezhnoy.domain.HttpRequest;
import ru.aberezhnoy.domain.HttpResponse;
import ru.aberezhnoy.domain.HttpResponseCode;
import ru.aberezhnoy.service.FileService;
import ru.aberezhnoy.service.ResponseSerializer;
import ru.aberezhnoy.service.SocketService;

@Handler(order = 1)
class PostMethodHandler extends MethodHandlerImpl {

    public PostMethodHandler(MethodHandler next, SocketService socketService, ResponseSerializer responseSerializer, FileService fileService) {
        super("POST", next, socketService, responseSerializer);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        return HttpResponse.createBuilder()
                .setStatus(HttpResponseCode.OK)
                .setHeaders("Content-Type", "text/html; charset=utf-8")
                .setBody("<H2>POST method handled!<H2>")
                .build();
    }
}

