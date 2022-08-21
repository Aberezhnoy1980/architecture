package ru.aberezhnoy.service;

import ru.aberezhnoy.domain.HttpRequest;

import java.util.Deque;

public interface RequestParser {

    HttpRequest parseRequest(Deque<String> rawRequest);
}
