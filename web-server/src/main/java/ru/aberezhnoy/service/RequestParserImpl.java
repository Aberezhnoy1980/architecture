package ru.aberezhnoy.service;

import ru.aberezhnoy.domain.HttpRequest;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class RequestParserImpl implements RequestParser {

    @Override
    public HttpRequest parseRequest(Deque<String> rawRequest) {
        String[] firstLine = rawRequest.pollFirst().split(" ");
        HttpRequest.Builder builder = HttpRequest.createBuilder();
        builder
                .setMethod(firstLine[0])
                .setUrl(firstLine[1]); // build on track
//        String method = firstLine[0]; // construct return expression at the end
//        String url = firstLine[1]; // construct return expression at the end

//        Map<String, String> headers = new HashMap<>(); //construct return expression at the end
//        String[] lines = new String[0]; //construct return expression at the end
        while (!rawRequest.isEmpty()) {
            String line = rawRequest.pollFirst();
            if (line.isBlank())
                break;
            String[] headers = line.split(": "); // build on track
            builder.setHeaders(headers[0], headers[1]);
//            lines = line.split(": "); // construct return expression at the end
//            headers.put(lines[0], lines[1]); // construct return expression at the end
        }

        StringBuilder body = new StringBuilder();
        while (!rawRequest.isEmpty()) {
            builder.setBody(body.append(rawRequest.pollFirst()).toString()); // build on track
//            body.append(rawRequest.pollFirst()); // construct return expression at the end
        }

        return builder.build();
//        return HttpRequest.newHttpRequest(method, url, headers, body.toString()); // through "factory" expression
//        return HttpRequest
//                .createBuilder()
//                .setMethod(method)
//                .setUrl(url)
//                .setHeaders(lines[0], lines[1])
//                .setBody(body.toString())
//                .build(); // through inner builder
//        return new HttpRequest(method, url, headers, body.toString()); // regular: when use this needs to make constructor public
    }
}
