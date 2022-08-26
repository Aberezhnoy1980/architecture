package ru.aberezhnoy.service;

import ru.aberezhnoy.service.ResponseSerializer;
import ru.aberezhnoy.service.ResponseSerializerImpl;

public final class ResponseSerializerFactory {

    public static ResponseSerializer create() {
        return new ResponseSerializerImpl();
    }
}
