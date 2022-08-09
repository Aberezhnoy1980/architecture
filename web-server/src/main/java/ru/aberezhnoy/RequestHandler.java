package ru.aberezhnoy;

import ru.aberezhnoy.service.FileService;
import ru.aberezhnoy.service.SocketService;

import java.io.IOException;

public class RequestHandler implements Runnable {

    private final SocketService socketService;

    private final FileService fileService;

    public RequestHandler(SocketService socketService, FileService fileService) {
        this.socketService = socketService;
        this.fileService = fileService;
    }

    @Override
    public void run() {
//        try (BufferedReader input = new BufferedReader(
//                new InputStreamReader(
//                        socket.getInputStream(), StandardCharsets.UTF_8));
//             PrintWriter output = new PrintWriter(socket.getOutputStream())
//        ) {
//            while (!input.ready()) ;


//            String firstLine = input.readLine();
        String firstLine = socketService.readRequest();
        String[] parts = firstLine.split(" ");
//            System.out.println(firstLine);
//            while (input.ready()) {
//                System.out.println(input.readLine());
//            }
//
//            Path path = Paths.get(folder, parts[1]);
        if (!fileService.exists(parts[1])) {
            String response =
                    "HTTP/1.1 404 NOT FOUND\n" +
                            "Content-type: text/html; charset=utf-8\n" +
                            "\n" +
                            "<h1>File not found!<h1>";
            socketService.writeResponse(response);
//                output.println("HTTP/1.1 404 NOT FOUND");
//                output.println("Content-type: text/html; charset=utf-8");
//                output.println();
//                output.println("<h1>File not found!<h1>");
//                output.flush();
            return;
        }

        String response =
                "HTTP/1.1 200 OK\n" +
                        "Content-type: text/html; charset=utf-8\n" +
                        "\n" +
                        fileService.readFile(parts[1]);
        socketService.writeResponse(response);

//            output.println("HTTP/1.1 200 OK");
//            output.println("Content-type: text/html; charset=utf-8");
//            output.println();


//        Files.newBufferedReader(path).transferTo(output);

        try {
            socketService.close();
        } catch (IOException exception) {
            throw new IllegalStateException(exception);
        }
        System.out.println("Client disconnected");
    }
}

