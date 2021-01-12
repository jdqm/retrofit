package com.example.printer;

/**
 * Created by Jdqm on 2021/1/12
 */
public class EvenPrinter implements Runnable {
    private final Counter counter;

    public EvenPrinter(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        synchronized (counter) {
            while (counter.value <= 100) {
                if (!counter.isOdd) {
                    System.out.println(counter.value);
                    counter.value++;
                    counter.isOdd = !counter.isOdd;
                    counter.notify();
                }
                if (counter.value <= 100) {
                    try {
                        counter.wait();
                    } catch (InterruptedException e) {
//                    e.printStackTrace();
                    }
                }
            }
        }
    }
}
