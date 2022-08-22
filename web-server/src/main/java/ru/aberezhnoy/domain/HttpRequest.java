package ru.aberezhnoy.domain;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {

    private Map<String, String> headers = new HashMap<>();
    private String method;
    private String url;
    private String body;

    private HttpRequest() {
    }

    private HttpRequest(String method, String url, Map<String, String> headers, String body) {
        this.method = method;
        this.url = url;
        this.headers = headers;
        this.body = body;
    }

    public static HttpRequest newHttpRequest(String method, String url, Map<String, String> headers, String body) {
        return new HttpRequest(method, url, headers, body);
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public static class Builder {

        private final HttpRequest httpRequest;

        public Builder() {
            this.httpRequest = new HttpRequest();
        }

        public Builder setMethod(String method) {
            this.httpRequest.method = method;
            return this;
        }

        public Builder setUrl(String url) {
            this.httpRequest.url = url;
            return this;
        }

        public Builder setHeaders(String key, String value) {
            this.httpRequest.getHeaders().put(key, value);
            return this;
        }

        public Builder setBody(String body) {
            this.httpRequest.body = body;
            return this;
        }

        public HttpRequest build() {
            if (this.httpRequest.getMethod() == null) {
                throw new IllegalStateException("Method not defined");
            }
            if (this.httpRequest.getUrl() == null) {
                throw new IllegalStateException("Url not defined");
            }
            return httpRequest;
        }
    }
}