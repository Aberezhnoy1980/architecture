package ru.aberezhnoy.handler;

import ru.aberezhnoy.service.FileService;
import ru.aberezhnoy.service.ResponseSerializer;
import ru.aberezhnoy.service.SocketService;

public final class MethodHandlerFactory {

    public static MethodHandler create(SocketService socketService, ResponseSerializer responseSerializer, FileService fileService) {
        PutMethodHandler putMethodHandler = new PutMethodHandler(null, socketService, responseSerializer, fileService);
        PostMethodHandler postMethodHandler = new PostMethodHandler(putMethodHandler, socketService, responseSerializer, fileService);
        return new GetMethodHandler(postMethodHandler, socketService, responseSerializer, fileService);
    }
}
