package ru.aberezhnoy.handler;

import ru.aberezhnoy.domain.HttpRequest;
import ru.aberezhnoy.domain.HttpResponse;
import ru.aberezhnoy.domain.HttpResponseCode;
import ru.aberezhnoy.domain.HttpResponseMethod;
import ru.aberezhnoy.service.FileService;
import ru.aberezhnoy.service.ResponseSerializer;
import ru.aberezhnoy.service.SocketService;

@Handler(order = 0)
class GetMethodHandler extends MethodHandlerImpl {

    private final FileService fileService;
    private final String headerKey = "Content-Type";
    private final String headerValue = "charset=utf-8";
    private final String body = "<H2>File not found!<H2>";

    public GetMethodHandler(MethodHandler next,
                            SocketService socketService,
                            ResponseSerializer responseSerializer,
                            FileService fileService) {
        super(String.valueOf(HttpResponseMethod.GET), next, socketService, responseSerializer);
        this.fileService = fileService;
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        if (!fileService.exists(request.getUrl())) {
            return HttpResponse
                    .createBuilder()
                    .setStatus(HttpResponseCode.NOT_FOUND)
                    .setHeaders(headerKey, headerValue)
                    .setBody(body)
                    .build();

        } else if (fileService.isDirectory(request.getUrl())) {
            return HttpResponse
                    .createBuilder()
                    .setStatus(HttpResponseCode.BAD_REQUEST)
                    .setHeaders(headerKey, headerValue)
                    .setBody("<H2>" + fileService.readFile(request.getUrl()) + "<H2>")
                    .build();
        } else {
            return HttpResponse
                    .createBuilder()
                    .setStatus(HttpResponseCode.OK)
                    .setHeaders(headerKey, headerValue)
                    .setBody("<H2>" + fileService.readFile(request.getUrl()) + "<H2>")
                    .build();
        }
    }
}
