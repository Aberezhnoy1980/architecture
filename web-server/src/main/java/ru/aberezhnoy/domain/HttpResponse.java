package ru.aberezhnoy.domain;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse {

    private HttpResponseCode statusCode;
    private Map<String, String> headers = new HashMap<>();
    private String body;

    private HttpResponse() {
    }

//    private HttpResponse(HttpResponseCode statusCode, Map<String, String> headers, String body) {
//        this.statusCode = statusCode;
//        this.headers = headers;
//        this.body = body;
//    }

    public static HttpResponse createHttpResponse() {
        return new HttpResponse();
    }

    public static Builder createBuilder() {
        return new Builder();
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public static class Builder {

        private final HttpResponse httpResponse;

        public Builder() {
            this.httpResponse = new HttpResponse();
        }

        public Builder setStatus(HttpResponseCode statusCode) {
            this.httpResponse.setStatusCode(statusCode);
            return this;
        }

        public Builder setHeaders(String key, String value) {
            this.httpResponse.getHeaders().put(key, value);
            return this;
        }

        public Builder setBody(String body) {
            this.httpResponse.setBody(body);
            return this;
        }

        public HttpResponse build() {
            if (this.httpResponse.statusCode == null) {
//            if (this.httpResponse.statusCode.status.isBlank()) {
//            if (this.httpResponse.statusCode.status.isEmpty()) {
//            if (this.httpResponse.statusCode != null) { // from lesson and I don't understand?? (exception)
//            if (this.httpResponse.statusCode.status != null) { // the same
//            if (!this.httpResponse.statusCode.equals(null)) { // the same
//            if (!this.httpResponse.statusCode.status.isBlank()) { // the same
//            if (!this.httpResponse.statusCode.status.isEmpty()) { // the same
                throw new IllegalStateException("Status code not defined");
            }
            return httpResponse;
        }
    }
}
