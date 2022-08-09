package ru.aberezhnoy.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    private String rootDir;

    private String filename;

    public FileService(String rootDir, String filename) {
        this.rootDir = rootDir;
        this.filename = filename;
    }

    Path path = Paths.get(rootDir, filename);

    public boolean exists(String filename) {
        return Files.exists(path);
    }

    public String readFile(String filename) {
        try {
            Files.newBufferedReader(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path.toString();
    }
}
