package ru.aberezhnoy;

import org.junit.Assert;
import org.junit.Test;
import ru.aberezhnoy.domain.HttpResponse;
import ru.aberezhnoy.service.ResponseSerializerImpl;

import static ru.aberezhnoy.domain.HttpResponseCode.*;

public class ResponseSerializerTest {

    private final ResponseSerializerImpl responseParser = new ResponseSerializerImpl();

    @Test
    public void testSerializingNotFound() {
//        HttpResponse respNotFound = new HttpResponse();
//        respNotFound.setStatusCode(NOT_FOUND);
//        respNotFound.getHeaders().put("Content-type", "text/html; charset=utf-8");
//        respNotFound.setBody("<h2>File not found!<h2>");

        String responseNotFound = responseParser
                .serializeResponse(HttpResponse
                        .createBuilder()
                        .setStatus(NOT_FOUND)
                        .setHeaders("Content-type", "text/html; charset=utf-8")
                        .setBody("<h2>File not found!<h2>")
                        .build());

        Assert.assertEquals("HTTP/1.1 404 NOT FOUND\n" +
                "Content-type: text/html; charset=utf-8\n" +
                "\n" +
                "<h2>File not found!<h2>", responseNotFound);
    }

    @Test
    public void testSerializingBadRequest() {
//        HttpResponse respBadRequest = new HttpResponse();
//        respBadRequest.setStatusCode(HttpResponseCode.BAD_REQUEST);
//        respBadRequest.getHeaders().put("Content-type", "text/html; charset=utf-8");
//        respBadRequest.setBody("<H2>Bad<H2>");

        String responseBadRequest = responseParser
                .serializeResponse(HttpResponse
                        .createBuilder()
                        .setStatus(BAD_REQUEST)
                        .setHeaders("Content-type", "text/html; charset=utf-8")
                        .setBody("<H2>Bad<H2>")
                        .build());

        Assert.assertEquals("HTTP/1.1 400 BAD REQUEST\n" +
                "Content-type: text/html; charset=utf-8\n" +
                "\n" +
                "<H2>Bad<H2>", responseBadRequest);
    }

    @Test
    public void testSerializingOK() {
//        HttpResponse respOK = new HttpResponse();
//        respOK.setStatusCode(HttpResponseCode.OK);
//        respOK.getHeaders().put("Content-type", "text/html; charset=utf-8");
//        respOK.setBody("<H2>OK<H2>");

        String responseOK = responseParser
                .serializeResponse(HttpResponse
                        .createBuilder()
                        .setStatus(OK)
                        .setHeaders("Content-type", "text/html; charset=utf-8")
                        .setBody("<H2>OK<H2>")
                        .build());

        Assert.assertEquals("HTTP/1.1 200 OK\n" +
                "Content-type: text/html; charset=utf-8\n" +
                "\n" +
                "<H2>OK<H2>", responseOK);
    }
}









