package ru.aberezhnoy;

import ru.aberezhnoy.domain.HttpResponse;

public interface ResponseSerializer {

    String serializeResponse(HttpResponse httpResponse);
}
