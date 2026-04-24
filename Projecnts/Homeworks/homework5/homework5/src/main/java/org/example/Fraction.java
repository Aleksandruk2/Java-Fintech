package org.example;

public class Fraction {
    public int numerator;     // чисельник
    public int denominator;   // знаменник

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
