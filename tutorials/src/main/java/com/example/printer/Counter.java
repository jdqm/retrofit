package com.example.printer;

/**
 * Created by Jdqm on 2021/1/12
 */
public class Counter {
    public int value;
    public boolean isOdd;

    public static void main(String[] args) {
        Counter counter = new Counter();
        new Thread(new EvenPrinter(counter)).start();
        new Thread(new OddPrinter(counter)).start();
    }
}
