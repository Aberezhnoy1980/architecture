package ru.aberezhnoy.factory;

import ru.aberezhnoy.service.SocketService;
import ru.aberezhnoy.service.SocketServiceImpl;

import java.net.Socket;

public final class SocketServiceFactory {

    public static SocketService create(Socket socket) {
        return new SocketServiceImpl(socket);
    }
}
