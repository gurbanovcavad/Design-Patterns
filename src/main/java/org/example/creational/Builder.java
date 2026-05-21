package org.example.creational;

import java.util.ArrayList;
import java.util.List;

class HttpRequest {

    private final String url;
    private final String method;
    private final String body;
    private final List<String[]> headers;

    private HttpRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.body = builder.body;
        this.headers = List.copyOf(builder.headers);
    }

    public static class Builder {

        private String url;
        private String method;
        private String body;
        private List<String[]> headers = new ArrayList<>();

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setMethod(String method) {
            this.method = method;
            return this;
        }

        public Builder addHeader(String header, String value) {
            this.headers.add(new String[]{header, value});
            return this;
        }

        public Builder setBody(String body) {
            this.body = body;
            return this;
        }

        public HttpRequest build() {
            return new HttpRequest(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder headerString = new StringBuilder("{\n");
        for (var header : this.headers) {
            headerString.append("\t\t")
                    .append(header[0])
                    .append(": ")
                    .append(header[1])
                    .append(",\n");

        }
        headerString.append("\t}");
        return "{\n" +
                "\turl: " + this.url + ",\n" +
                "\tbody: " + this.body + ",\n" +
                "\tmethod: " + this.method + ",\n" +
                "\theaders: " + headerString + ",\n" +
                "}";
    }
}

public class Builder {
    public static void main(String[] args) {
        HttpRequest request = new HttpRequest.Builder()
                .setUrl("example.com")
                .setBody("Hello")
                .addHeader("Content-type", "application/json")
                .addHeader("Authorization", "Bearer kjhakjfankjfnaksa")
                .setMethod("POST")
                .build();

        System.out.println(request);
    }
}
