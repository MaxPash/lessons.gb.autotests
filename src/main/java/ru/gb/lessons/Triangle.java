package ru.gb.lessons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Triangle {
    private double a;
    private double b;
    private double c;
    private double p;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calculatePerimeter() {
        checkSidesArePositive();
        checkValid();
        return a + b + c;
    }

    public double calculateHalfPerimeter() {
        checkSidesArePositive();
        checkValid();
        return (a + b + c) / 2;
    }

    public double calculateArea() {
        checkSidesArePositive();
        checkValid();
        double p;
        p = calculateHalfPerimeter();
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    private void checkSidesArePositive() {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("The sides must be positive");
        }
    }

    private void checkValid() {
        double max = Math.max(Math.max(a, b), c);
        if (max >= (a + b + c - max)) {
            throw new IllegalArgumentException("The any two sides must be greater than third side");
        }
    }

}