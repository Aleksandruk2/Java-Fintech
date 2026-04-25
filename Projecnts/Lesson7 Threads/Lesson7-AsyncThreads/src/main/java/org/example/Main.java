package org.example;

import java.util.Currency;

public class Main {

    public static void simpleMethod() {
        Counter counter= new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.increment();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join(); //Очікує завершення роботи
            t2.join(); //Очікує завершення роботи
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getCount());
    }

    static void main() {
        System.out.println("Синхронізація потоків!");
//        simpleMethod();

        Thread t1 = new Thread(() -> Table.printTable(2));
        Thread t2 = new Thread(() -> Table.printTable(10));
        t1.start();
        t2.start();
    }
}
