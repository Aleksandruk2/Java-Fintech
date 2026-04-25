package org.example;

public class Counter {
    private int count = 0;

    // Синхронізація потоку, блокує весь метод
//    public synchronized void increment() {
//        count++;
//    }
//
    public void increment() {
        // Блокуємо небезпечний код
         synchronized (this) { count++; }
    }

    public  void decrement() {
        count--;
    }

    public int getCount(){
        return  count;
    }
}
