package ru.gb.lessons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Triangle {
    private int a;
    private int b;
    private int c;

    public int calculatePerimeter() {
        checkSidesArePositive();
        checkValid();
        return a + b + c;
    }

    private void checkSidesArePositive() {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("The sides must be positive");
        }
    }

    private void checkValid() {
        long max = Math.max(Math.max(a, b), c);
        if (max >= (a + b + c - max)) {
            throw new IllegalArgumentException("The any two sides must be greater than third side");
        }
    }
}