package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


import java.io.IOException;

public class TestHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String message = "Hello Rabbit";
        exchange.sendResponseHeaders(200, message.length());
        exchange.getResponseBody().write(message.getBytes());
        exchange.getResponseBody().close();
    }
}
