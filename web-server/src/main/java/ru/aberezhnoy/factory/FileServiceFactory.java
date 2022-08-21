package ru.aberezhnoy.factory;

import ru.aberezhnoy.service.FileService;
import ru.aberezhnoy.service.FileServiceImpl;

public final class FileServiceFactory {

    public static FileService create(String rootDir) {
        return new FileServiceImpl(rootDir);
    }
}
