package org.example;

public class FillThread implements Runnable {
    private ArrayProcessor processor;

    public FillThread(ArrayProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void run() {
        processor.fillArray();
    }
}

