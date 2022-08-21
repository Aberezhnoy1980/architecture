package ru.aberezhnoy;

import ru.aberezhnoy.domain.HttpRequest;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RequestParserImpl implements RequestParser {

    @Override
    public HttpRequest parseRequest(Deque<String> rawRequest) {
        String[] firstLine = rawRequest.pollFirst().split(" ");
        String method = firstLine[0];
        String url = firstLine[1];

        Map<String, String> headers = new HashMap<>();
        String[] lines = new String[0];
        while (!rawRequest.isEmpty()) {
            String line = rawRequest.pollFirst();
            if (line.isBlank())
                break;
            lines = line.split(": ");
            headers.put(lines[0], lines[1]);
        }

        StringBuilder body = new StringBuilder();
        while (!rawRequest.isEmpty()) {
            body.append(rawRequest.pollFirst());
        }

//        return HttpRequest.newHttpRequest(method, url, headers, body.toString());
        return HttpRequest
                .createBuilder()
                .setMethod(method)
                .setUrl(url)
                .setHeaders(lines[0], lines[1])
                .setBody(body.toString())
                .build();
//        return new HttpRequest(method, url, headers, body.toString()); if use this needs to make constructor public
    }
}
