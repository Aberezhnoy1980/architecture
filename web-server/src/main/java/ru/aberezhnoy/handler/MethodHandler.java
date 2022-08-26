package ru.aberezhnoy.handler;

import ru.aberezhnoy.domain.HttpRequest;

public interface MethodHandler {
    void handle(HttpRequest request);
}
