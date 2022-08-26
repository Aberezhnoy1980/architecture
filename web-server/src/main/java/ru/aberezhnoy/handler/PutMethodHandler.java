package ru.aberezhnoy.handler;

import ru.aberezhnoy.config.ServerConfig;
import ru.aberezhnoy.domain.HttpRequest;
import ru.aberezhnoy.domain.HttpResponse;
import ru.aberezhnoy.domain.HttpResponseCode;
import ru.aberezhnoy.service.ResponseSerializer;
import ru.aberezhnoy.service.SocketService;

@Handler(method = "PUT", order = 2)
class PutMethodHandler extends MethodHandlerImpl {

    public PutMethodHandler(MethodHandlerImpl next, SocketService socketService, ResponseSerializer responseSerializer, ServerConfig config) {
        super("PUT", next, socketService, responseSerializer, config);
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
