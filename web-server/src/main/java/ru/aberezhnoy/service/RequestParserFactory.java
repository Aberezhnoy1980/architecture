package ru.aberezhnoy.service;

import ru.aberezhnoy.service.RequestParser;
import ru.aberezhnoy.service.RequestParserImpl;

public final class RequestParserFactory {

    public static RequestParser create() {
        return new RequestParserImpl();
    }
}
