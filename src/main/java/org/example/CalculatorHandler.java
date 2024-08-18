package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.Map;

public class CalculatorHandler implements HttpHandler {
    private static Map<String, String> getParameters(String query) {
        String[] split = query.split("&");
        Map<String, String> parameters = new HashMap<>();

        for (String s : split) {
            String[] split1 = s.split("=");
            parameters.put(split1[0], split1[1]);
        }

        return parameters;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {


        String query = exchange.getRequestURI().getQuery();

        Map<String, String> parameters = getParameters(query);
        String result = "Result = ";
        double num1 = Double.parseDouble(parameters.get("num1"));
        double num2 = Double.parseDouble(parameters.get("num2"));
        double resultOperation = switch (parameters.get("type")) {
            case "sum" -> num1 + num2;
            case "sub" -> num1 - num2;
            case "mul" -> num1 * num2;
            case "div" -> num1 / num2;
            default -> throw new IllegalStateException("Unexpected value: " + parameters.get("type"));
        };
        Conteiner conteiner = new Conteiner();
        LocalDateTime localDateTime = LocalDateTime.now();
        String dtg = localDateTime.toString();
        conteiner.addResult(dtg, num1, num2, parameters.get("type"), resultOperation);
        String response = result + resultOperation;
        exchange.sendResponseHeaders(200, response.length());
        exchange.getResponseBody().write(response.getBytes());
        exchange.getResponseBody().close();


    }
}







