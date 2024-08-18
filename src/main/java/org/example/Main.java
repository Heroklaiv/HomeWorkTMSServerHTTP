package org.example;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8801),0);
        httpServer.createContext("/test", new TestHandler() );
        httpServer.createContext("/calculator", new CalculatorHandler());
        httpServer.createContext("/history",new HistoryOperation());
        httpServer.start();

    }
}