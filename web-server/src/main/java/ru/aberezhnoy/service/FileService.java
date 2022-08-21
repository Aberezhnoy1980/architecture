package ru.aberezhnoy.service;

public interface FileService {

    String readFile(String filename);

    boolean exists(String filename);

    boolean isDirectory(String filename);
}
