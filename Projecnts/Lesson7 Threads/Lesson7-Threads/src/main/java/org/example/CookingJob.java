package org.example;

public class CookingJob implements Runnable{
    public String task;

    public CookingJob(String task) {
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println("CookingJob: " + task +
                "\t Thread: " + Thread.currentThread().getName());
    }
}
