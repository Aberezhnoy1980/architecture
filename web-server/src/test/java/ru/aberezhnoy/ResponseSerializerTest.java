package ru.aberezhnoy;

import org.junit.Assert;
import org.junit.Test;
import ru.aberezhnoy.domain.HttpRequest;
import ru.aberezhnoy.service.RequestParser;

import java.util.AbstractMap;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class RequestParserTest {

    private static final String rawTestRequest =
            "GET /index.html HTTP/1.1\n" +
                    "Host: localhost:8088\n" +
                    "Connection: keep-alive\n" +
                    "\n";

    private final RequestParser requestParser = new RequestParser();

    @Test
    public void testParsing() {
        Deque<String> raw = new LinkedList<>();
        rawTestRequest.lines().forEach(raw::add);
        HttpRequest req = requestParser.parseRequest(raw);

        Assert.assertEquals("GET", req.getMethod());
        Assert.assertEquals("/index.html", req.getUrl());
    }
}









