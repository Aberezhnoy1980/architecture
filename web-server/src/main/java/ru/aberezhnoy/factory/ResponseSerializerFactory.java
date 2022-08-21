package ru.aberezhnoy.factory;

import ru.aberezhnoy.service.ResponseSerializer;
import ru.aberezhnoy.service.ResponseSerializerImpl;

public final class ResponseSerializerFactory {

    public static ResponseSerializer create() {
        return new ResponseSerializerImpl();
    }
}
