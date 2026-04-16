package org.example;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    static void main() {
        var bobik = new Dog();
        bobik.eat();

        Animal animal = new Dog("Бобік", 3, "Вовчарка Німецька");
        animal.eat();

        // is - C#, instanceof - Java
        if(animal instanceof Dog dog) {
            dog.bark();

        }

        System.out.println("Кількість створених об'єктів " + Animal.getCounter());
        System.out.println("Максимальний вік " + IAnimal.MAX_AGE);

        animal.makeSound();

        animal.eatBear();
        IAnimal.handleMethod();

        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        obj1 = null; // Більше не доступний

        obj2 = new Object();
        obj3 = obj2;

        System.gc(); //виклик явно GB
    }
}
