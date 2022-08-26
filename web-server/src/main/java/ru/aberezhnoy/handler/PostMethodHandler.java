package ru.aberezhnoy.handler;

import ru.aberezhnoy.config.ServerConfig;
import ru.aberezhnoy.domain.HttpRequest;
import ru.aberezhnoy.domain.HttpResponse;
import ru.aberezhnoy.domain.HttpResponseCode;
import ru.aberezhnoy.service.ResponseSerializer;
import ru.aberezhnoy.service.SocketService;

import java.lang.reflect.Method;

@Handler(method = "POST", order = 1)
class PostMethodHandler extends MethodHandlerImpl {

    public PostMethodHandler(MethodHandlerImpl next, SocketService socketService, ResponseSerializer responseSerializer, ServerConfig config) {
        super("POST", next, socketService, responseSerializer, config);
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

