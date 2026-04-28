package org.example;

import java.util.Arrays;

public class Main {
    static void main() throws InterruptedException {
        ArrayProcessor processor = new ArrayProcessor(10);

//        Thread t1 = new FillThread(processor);
//        Thread t2 = new SumThread(processor);
//        Thread t3 = new AvgThread(processor);

        FillThread fillThread = new FillThread(processor);
        SumThread sumThread = new SumThread(processor);
        AvgThread avgThread = new AvgThread(processor);

        Thread t1 = new Thread(fillThread);
        Thread t2 = new Thread(sumThread);
        Thread t3 = new Thread(avgThread);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("\nМасив: " + Arrays.toString(processor.getArray()));
        System.out.println("Сума: " + processor.getSum());
        System.out.println("Середнє: " + processor.getAvg());
    }
}
