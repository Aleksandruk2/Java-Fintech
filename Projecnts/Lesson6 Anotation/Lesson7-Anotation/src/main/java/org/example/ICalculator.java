package org.example;

@FunctionalInterface
public interface ICalculator {
    int add(int a, int b);
    // цае для static та default анотація @FunctionalInterface
    static void PrintHello() {
        System.out.println("Hello");
    }
}
