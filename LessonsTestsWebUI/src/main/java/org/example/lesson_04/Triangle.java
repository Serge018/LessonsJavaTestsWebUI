package org.example.lesson_04;

/**
* Набор вспомогательных функций для реботы с треугольником
*/
public class Triangle
{
    /**
    * Функция расчёта площади треугольника по длине сторон
    */
     static public int calculateArea(int a, int b, int c) throws GeometryException
     {
         // Проверка переданных значений
         boolean isAvailableTriangleSidesValues = (a > 0) && (b > 0) && (c > 0);
         if (!isAvailableTriangleSidesValues)
         {
             throw new GeometryException("Сторононы треугольника не могут быть равны нулю или быть меньше. Передано: " + a + ", " + b + ", " + c);
         }

         // Расчёт площади треугольника
         double semiPerimeter = (a + b + c) / 2;
         double area = Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));

         // Для простоты проверки результат приводим к целочисленному значению
         int result = (int) Math.round(area);

         return result;
     }
}
