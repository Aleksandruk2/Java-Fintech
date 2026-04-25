package org.example;

public class CookingTask extends Thread {
    private String task;

    public CookingTask(String task) {
        this.task = task;
    }

    public void run() {
        System.out.println("Cooking: " + task +
                "\t Thread: " + Thread.currentThread().getName());
    }
}
