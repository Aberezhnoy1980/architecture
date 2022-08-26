package ru.aberezhnoy.handler;

import ru.aberezhnoy.config.ServerConfig;
import ru.aberezhnoy.domain.HttpRequest;
import ru.aberezhnoy.domain.HttpResponse;
import ru.aberezhnoy.domain.HttpResponseCode;
import ru.aberezhnoy.service.FileService;
import ru.aberezhnoy.service.ResponseSerializer;
import ru.aberezhnoy.service.SocketService;

@Handler(method = "GET", order = 0)
class GetMethodHandler extends MethodHandlerImpl {

    private final FileService fileService;

    public GetMethodHandler(MethodHandlerImpl next,
                            SocketService socketService,
                            ResponseSerializer responseSerializer,
                            ServerConfig config,
                            FileService fileService) {
        super("GET", next, socketService, responseSerializer, config);
        this.fileService = fileService;
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        if (!fileService.exists(request.getUrl())) {
            return HttpResponse
                    .createBuilder()
                    .setStatus(HttpResponseCode.NOT_FOUND)
                    .setHeaders("Content-Type", "text/html; charset=utf-8")
                    .setBody("<H2>File not found!<H2>")
                    .build();

        } else if (fileService.isDirectory(request.getUrl())) {
            return HttpResponse
                    .createBuilder()
                    .setStatus(HttpResponseCode.BAD_REQUEST)
                    .setHeaders("Content-Type", "text/html; charset=utf-8")
                    .setBody("<H2>" + fileService.readFile(request.getUrl()) + "<H2>")
                    .build();
        } else {
            return HttpResponse
                    .createBuilder()
                    .setStatus(HttpResponseCode.OK)
                    .setHeaders("Content-Type", "text/html; charset=utf-8")
                    .setBody("<H2>" + fileService.readFile(request.getUrl()) + "<H2>")
                    .build();
        }
    }
}
