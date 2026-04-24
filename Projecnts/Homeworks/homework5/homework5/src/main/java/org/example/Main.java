package org.example;

import java.util.function.BiFunction;

public class Main {
    static void main(String[] args) {
        // Завдання 2
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(3, 4);

        BiFunction<Fraction, Fraction, Fraction> sum = (a, b) ->
                new Fraction(a.numerator * b.denominator + b.numerator * a.denominator,
                        a.denominator * b.denominator);

        BiFunction<Fraction, Fraction, Fraction> diff = (a, b) ->
                new Fraction(a.numerator * b.denominator - b.numerator * a.denominator,
                        a.denominator * b.denominator);

        BiFunction<Fraction, Fraction, Fraction> multiply = (a, b) ->
                new Fraction(a.numerator * b.numerator,
                        a.denominator * b.denominator);

        BiFunction<Fraction, Fraction, Fraction> divide = (a, b) ->
                new Fraction(a.numerator * b.denominator,
                        a.denominator * b.numerator);

        System.out.println("Дріб f1: " + f1 + ", дріб f2: " + f2);
        System.out.println("Сума: " + sum.apply(f1, f2));
        System.out.println("Різниця: " + diff.apply(f1, f2));
        System.out.println("Множення: " + multiply.apply(f1, f2));
        System.out.println("Ділення: " + divide.apply(f1, f2));
    }
}