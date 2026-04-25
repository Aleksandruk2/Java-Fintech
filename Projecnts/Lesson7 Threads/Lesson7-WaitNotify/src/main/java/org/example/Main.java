package org.example;

public class Main {
    static void main() {
        System.out.println("Hello world");
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        //Виробник виробляє товари, які потрапляють у магазин
        new Thread(producer).start();
        //Коли товари потраипли у магазин, покупець може їх купити
        new Thread(consumer).start();
    }
}
