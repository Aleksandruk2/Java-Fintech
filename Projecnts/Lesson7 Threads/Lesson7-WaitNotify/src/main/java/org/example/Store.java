package org.example;

public class Store {
    private int product = 0;

    public synchronized void get() {
        while (product < 1) {
            try {
                System.out.println("Покупець очікує товари у магазині... " + product);
                wait(); // Очікуємо коли продукт появиться в магазині - очікує notify()
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product--;
        System.out.println("Клієнт купив 1 товар");
        System.out.println("Кількість товарів на складі: " + product);
        notify(); // повідомить, про те, що продукт був куплений у магазині
    }
    public synchronized void put() {
        while (product >= 3) {
            try {
                wait(); //Зупиняєтья, щоб крієнт міг купити товари
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        product++;
        System.out.println("Виробниу додав 1 товар");
        System.out.println("Кількість товарів на складі: " + product);
        notify();
    }
}
