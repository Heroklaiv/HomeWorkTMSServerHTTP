package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


import java.io.*;

public class HistoryOperation implements HttpHandler {

    private String readHistory() throws IOException {
        String response = "";
        BufferedReader reader = new BufferedReader(new FileReader("container.txt"));
        String line;


        while ((line = reader.readLine()) != null) {
            response = response + line + "\n";
        }
        reader.close();


        return response;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String message = readHistory();
        exchange.sendResponseHeaders(200, message.length());
        exchange.getResponseBody().write(message.getBytes());
        exchange.getResponseBody().close();


    }
}
