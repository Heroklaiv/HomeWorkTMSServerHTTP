package org.example;

import java.io.*;


public class Conteiner {
    private double num1;
    private double num2;
    private double result;
    private String operation;
    private  String dtg;

    public void addResult(String dtg, double num1, double num2, String operation, double result) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
        this.operation = operation;
        this.dtg = dtg;
        copy();
    }

    public void copy() {

        String text =dtg +"  "+ "num 1 = " + String.valueOf(num1) + " " + "num 2 = " + String.valueOf(num2) + " " + "type operation = " + operation + " " + "result = " + String.valueOf(result) + "\n";
        try {
            FileWriter writer = new FileWriter("container.txt", true);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
