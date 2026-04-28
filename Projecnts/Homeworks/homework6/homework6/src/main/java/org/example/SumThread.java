package org.example;

public class SumThread implements Runnable {
    private ArrayProcessor processor;

    public SumThread(ArrayProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void run() {
        processor.calculateSum();
    }
}
