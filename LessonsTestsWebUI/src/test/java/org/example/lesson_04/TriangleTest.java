package org.example.lesson_04;

import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Тесты класса Triangle
 */
@Story("Вспомогательные функции расчёта площади треугольника")
public class TriangleTest
{
    static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void logStartTriangleTests()
    {
        logger.info("Запуск тестов класса Triangle");
    }

    @DisplayName("Простая проверка расчёта площади треугольника по длине сторон")
    @ParameterizedTest
    @CsvSource({ "3, 4, 5, 6", "54, 32, 75, 707"})
    void calculateAreaSimple(int a, int b, int c, int result) throws GeometryException
    {
        int area = Triangle.calculateAreaBySidesLength(a, b, c);
        Assertions.assertEquals(result, area);
    }


    @DisplayName("Тест расчёта площади треугольника. Длины сторон имеют отрицательные значения или равны 0")
    @ParameterizedTest
    @Tag("Negative")
    @CsvSource({ "3, 0, 5", "-1, 32, 75", "-1, 32, 0"})
    void calculateAreaWithNegativeSideLength(int a, int b, int c)
    {
        Assertions.assertThrows(GeometryException.class, () -> Triangle.calculateAreaBySidesLength(a, b, c));
    }


    @DisplayName("Тест расчёта площади треугольника. Некорректныя длина у сторон, из переданных отрезков невозможно сложить треугольник")
    @ParameterizedTest
    @Tag("Negative")
    @CsvSource({"1, 1000, 1", "15, 35, 62", "44, 20, 71"})
    void calculateAreaNotAvailableTriangle(int a, int b, int c)
    {
        Assertions.assertThrows(GeometryException.class, () -> Triangle.calculateAreaBySidesLength(a, b, c));
    }
}
