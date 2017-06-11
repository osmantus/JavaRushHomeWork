package com.javarush.test.level04.lesson04.task08;

/* Треугольник
Ввести с клавиатуры три числа а, b, c – стороны предполагаемого треугольника.
Определить возможность существования треугольника по сторонам. Результат вывести на экран в следующем виде:
"Треугольник существует." - если треугольник с такими сторонами существует.
"Треугольник не существует." - если треугольник с такими сторонами не существует.
Подсказка: Треугольник существует только тогда, когда сумма любых двух его сторон больше третьей.
Требуется сравнить каждую сторону с суммой двух других.
Если хотя бы в одном случае сторона окажется больше суммы двух других, то треугольника с такими сторонами не существует.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        //System.out.print("Введите сторону <a>: ");
        String inputTxt = buffer.readLine();
        double a = Double.parseDouble(inputTxt);

        //System.out.print("Введите сторону <b>: ");
        inputTxt = buffer.readLine();
        double b = Double.parseDouble(inputTxt);

        //System.out.print("Введите сторону <c>: ");
        inputTxt = buffer.readLine();
        double c = Double.parseDouble(inputTxt);

        //if (a > 0 && b > 0 && c > 0)
        //{
            if (((a + b) > c) && ((a + c) > b) && ((b + c) > a))
                System.out.println("Треугольник существует.");
            else
                System.out.println("Треугольник не существует.");
        //}
        //else
        //    System.out.println("Треугольник не существует.");
    }
}