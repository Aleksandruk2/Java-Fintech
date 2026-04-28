package org.example;

import java.util.Random;

public class ArrayProcessor {
    private int[] array;
    private boolean isReady = false;

    private int sum;
    private double avg;

    public ArrayProcessor(int size) {
        array = new int[size];
    }

    public synchronized void fillArray() {
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("Масив заповнено");

        isReady = true;
        notify();
    }

    public synchronized void calculateSum() {
        while (!isReady) {
            try {
                System.out.println("Потік суми чекає...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int s = 0;
        for (int n : array) {
            s += n;
        }
        sum = s;

        System.out.println("Сума порахована");
    }

    public synchronized void calculateAvg() {
        while (!isReady) {
            try {
                System.out.println("Потік середнього чекає...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int s = 0;
        for (int n : array) {
            s += n;
        }
        avg = (double) s / array.length;

        System.out.println("Середнє пораховано");
    }

    public int[] getArray() {
        return array;
    }

    public int getSum() {
        return sum;
    }

    public double getAvg() {
        return avg;
    }
}
