package org.example;

public class AvgThread implements Runnable{
    private ArrayProcessor processor;

    public AvgThread(ArrayProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void run() {
        processor.calculateAvg();
    }
}
