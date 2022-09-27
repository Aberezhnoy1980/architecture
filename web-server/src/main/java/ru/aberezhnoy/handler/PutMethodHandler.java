package ru.aberezhnoy.handler;

import ru.aberezhnoy.domain.HttpRequest;
import ru.aberezhnoy.domain.HttpResponse;
import ru.aberezhnoy.domain.HttpResponseCode;
import ru.aberezhnoy.domain.HttpResponseMethod;
import ru.aberezhnoy.service.FileService;
import ru.aberezhnoy.service.ResponseSerializer;
import ru.aberezhnoy.service.SocketService;

@Handler(order = 2)
class PutMethodHandler extends MethodHandlerImpl {

    private final String headerKey = "Content-Type";
    private final String headerValue = "charset=utf-8";
    private final String body = "<H2>File not found!<H2>";

    public PutMethodHandler(MethodHandler next, SocketService socketService, ResponseSerializer responseSerializer, FileService fileService) {
        super(String.valueOf(HttpResponseMethod.POST), next, socketService, responseSerializer);
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
