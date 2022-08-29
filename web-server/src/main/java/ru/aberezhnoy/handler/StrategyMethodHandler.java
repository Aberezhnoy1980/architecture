package ru.aberezhnoy.handler;

import ru.aberezhnoy.config.ServerConfig;
import ru.aberezhnoy.domain.HttpRequest;
import ru.aberezhnoy.domain.HttpResponse;
import ru.aberezhnoy.service.ResponseSerializer;
import ru.aberezhnoy.service.SocketService;

import java.util.function.Function;

public class StrategyMethodHandler extends MethodHandlerImpl {

    private final Function<HttpRequest, HttpResponse> strategy;

    public StrategyMethodHandler(Function<HttpRequest, HttpResponse> strategy, String method, MethodHandlerImpl next, SocketService socketService, ResponseSerializer responseSerializer, ServerConfig config) {
        super(method, next, socketService, responseSerializer, config);
        this.strategy = strategy;
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        return strategy.apply(request);
    }

}
