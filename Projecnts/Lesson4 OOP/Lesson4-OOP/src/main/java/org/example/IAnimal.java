package org.example;

public interface IAnimal {
    // максимальний вік тварини 250 років
    int MAX_AGE = 250;
    void eat();
    void sleep();
    void makeSound();
    default void eatBear() {
        System.out.println("Тут може бути ведмідь 😋. Ням ням ням...");
    }

    static void handleMethod() {
        System.out.println("Це статичний метод");
    }
}
