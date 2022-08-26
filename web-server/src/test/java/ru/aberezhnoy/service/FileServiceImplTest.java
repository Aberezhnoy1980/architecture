package ru.aberezhnoy.service;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileServiceImplTest {



    @Test
    public void fileServerTest() throws IOException {
        StringBuilder sb = new StringBuilder();
//        try (FileReader reader = new FileReader("src/test/resources/test.html")) {
//            int c;
//            while ((c = reader.read()) != -1) {
//                sb.append((char) c);
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
        FileService fs = FileServiceFactory.create("src/test/resources");

        Files.readAllLines(Path.of("/Users/alex/Documents/Study/Portfolio/architecture/web-server/src/test/resources/test.html")).forEach(sb::append);

        Assert.assertEquals("java.io.IOException: Is a directory", fs.readFile(""));
        Assert.assertEquals(sb.toString(), fs.readFile("test.html"));
    }
}









