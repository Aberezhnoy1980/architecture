package ru.aberezhnoy.domain;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse {

    private HttpResponseCode statusCode;
    private Map<String, String> headers = new HashMap<>();
    private String body;

    public HttpResponse() {
    }

    public HttpResponse(HttpResponseCode statusCode, Map<String, String> headers, String body) {
        this.statusCode = statusCode;
        this.headers = headers;
        this.body = body;
    }

    public HttpResponseCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpResponseCode statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
