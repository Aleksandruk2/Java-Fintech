package org.example;


import java.util.function.Function;

public class Main {
    public static void task1() {
        SumThree sum = (a, b, c) -> a + b + c;
        System.out.println("Сумма трьох чисел: " + sum.apply(2,3,5));

        MultipleThree multiple = (a,b,c) -> a * b * c;
        System.out.println("Добуток: " + multiple.apply(2,2,3));

        Runnable showTime = () -> {
            System.out.println("Поточний час: " + java.time.LocalTime.now());
        };
        showTime.run();

        Runnable showDate = () -> {
            System.out.println("Поточна дата: " + java.time.LocalDate.now());
        };
        showDate.run();
    }

    public static void task2() {
        MaxMinFromTwo max = (a, b) -> a > b ? a : b;
        System.out.println("Максимальне число: " + max.apply(1,3));

        MaxMinFromTwo min = (a,b) -> a < b ? a : b;
        System.out.println("Мінамальне число: " + min.apply(5,2));

        Function<Integer, Integer> function = (n) -> {
            int result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;
            }
            return result;
        };
        System.out.println("Факторіал: " + function.apply(4));
    }

    static void main() {
//        task1();
        task2();

    }
}
