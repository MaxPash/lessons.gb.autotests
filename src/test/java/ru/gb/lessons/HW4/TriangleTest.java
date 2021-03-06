package ru.gb.lessons.HW4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.gb.lessons.Triangle;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;


public class TriangleTest {
    @Test
    @DisplayName("Тест ошибки треугольник с отрицательной стороной Junit")
    void catchExceptionPositiveSidesByJunitTest() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Triangle(-1, 1, 50)
                .calculateArea());
        assertEquals("The sides must be positive", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Тест ошибки треугольника с невалидными сторонами Junit")
    void catchExceptionCorrectSidesValuesByJunitTest() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 1, 25)
                .calculateArea());
        assertEquals("The any two sides must be greater than third side", illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Тест ошибки треугольника с невалидными сторонами AssertJ")
    void catchExceptionCorrectSidesValuesByAssertJTest() {
        assertThatThrownBy(() -> new Triangle(1, 1, 25).calculateArea())
                .hasMessage("The any two sides must be greater than third side")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Тест ошибки треугольник с отрицательной стороной AssertJ")
    void catchExceptionPositiveSidesByAssertJTest() {
        assertThatThrownBy(() -> new Triangle(-1, 1, 1).calculateArea())
                .hasMessage("The sides must be positive")
                .isInstanceOf(IllegalArgumentException.class);
    }


    public static Stream<Arguments> triangleForPerimeter() {
                return Stream.of(Arguments.of(new Triangle(6, 7, 8), 21),
                Arguments.of(new Triangle(4, 4, 4), 12),
                Arguments.of(new Triangle(3, 3, 5), 11));
    }

    @ParameterizedTest(name = "Рассчитать периметр: для {0} периметр = {1}")
    @MethodSource("triangleForPerimeter")
    void trianglePerimeterTest(Triangle triangle, int expectedResult) {
        double actualResult = triangle.calculatePerimeter();
        assertEquals(expectedResult, actualResult);
    }

    public static Stream<Arguments> triangleForArea() {
                return Stream.of(Arguments.of(new Triangle(3, 4, 5), 6),
                Arguments.of(new Triangle(7, 8, 9), 26.832815729997478),
                Arguments.of(new Triangle(10, 12, 14), 58.787753826796276));
    }

    @ParameterizedTest(name = "Рассчитать площадь треугольника: для {0} площадь = {1}")
    @MethodSource("triangleForArea")
    void triangleAreaTest(Triangle triangle, double expectedResult) {
        double actualResult = triangle.calculateArea();
        assertEquals(expectedResult, actualResult);
    }

}

