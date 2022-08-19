package ru.aberezhnoy.service;

import ru.aberezhnoy.domain.HttpRequest;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RequestParser {

    public HttpRequest parseRequest(Deque<String> rawRequest) {
        String[] firstLine = rawRequest.pollFirst().split(" ");
        String method = firstLine[0];
        String url = firstLine[1];

        Map<String, String> headers = new HashMap<>();
        while (!rawRequest.isEmpty()) {
            String line = rawRequest.pollFirst();
            if (line.isBlank())
                break;
            String[] lines = line.split(": ");
            headers.put(lines[0], lines[1]);
        }

        StringBuilder body = new StringBuilder();
        while (!rawRequest.isEmpty()) {
            body.append(rawRequest.pollFirst());
        }

        return new HttpRequest(method, url, headers, body.toString());
    }
}
