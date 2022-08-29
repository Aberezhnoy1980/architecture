package ru.aberezhnoy.handler;

import org.reflections.Reflections;
import ru.aberezhnoy.config.ServerConfig;
import ru.aberezhnoy.service.FileService;
import ru.aberezhnoy.service.ResponseSerializer;
import ru.aberezhnoy.service.SocketService;

import java.lang.annotation.Annotation;
import java.util.Set;

public final class MethodHandlerFactory {

    public static MethodHandler create(SocketService socketService, ResponseSerializer responseSerializer, ServerConfig config, FileService fileService) {
        PutMethodHandler putMethodHandler = new PutMethodHandler(null, socketService, responseSerializer, config);
        PostMethodHandler postMethodHandler = new PostMethodHandler(putMethodHandler, socketService, responseSerializer, config);
        return new GetMethodHandler(postMethodHandler, socketService, responseSerializer, config, fileService);
    }

//    public static MethodHandlerImpl createAnnotated() {
//        Reflections reflections = new Reflections("ru.aberezhnoy.handler");
//        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Handler.class);
//
//
//    }
}
