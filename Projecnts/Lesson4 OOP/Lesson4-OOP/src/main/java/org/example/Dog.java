package org.example;

public class Dog extends Animal{
    //final - як readonly у C#
    private String bread;
    // у C#
    public Dog(String name, int age, String bread) {
        super(name, age); // виклик батьківського коструктора
        this.bread = bread;
    }

    public Dog() {
        super("Барсик", 2); // виклик батьківського коструктора
        this.name = "Персик";
    }

    public void bark() {
        System.out.println(name + " гавкає: ГАВ!");
    }

    @Override
    public void eat() {
        bread = "Кусачий";
        System.out.println(name + " гризе кістку");
    }

//    @Override
//    public void sleep() {
//        System.out.println("Песик спить");
//    }

    @Override
    public void makeSound() {
        System.out.println("Гав Гав 🐶!");
    }
}
