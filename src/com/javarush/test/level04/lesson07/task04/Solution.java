package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String inputTxt1 = buffer.readLine();
        String inputTxt2 = buffer.readLine();
        String inputTxt3 = buffer.readLine();

        int number1 = Integer.parseInt(inputTxt1);
        int number2 = Integer.parseInt(inputTxt2);
        int number3 = Integer.parseInt(inputTxt3);

        int positiveNumber = 0;
        int negativeNumber = 0;

        if (number1 > 0)
            positiveNumber++;
        else if (number1 < 0)
            negativeNumber++;

        if (number2 > 0)
            positiveNumber++;
        else if (number2 < 0)
            negativeNumber++;

        if (number3 > 0)
            positiveNumber++;
        else if (number3 < 0)
            negativeNumber++;

        System.out.println("количество отрицательных чисел: " + negativeNumber);
        System.out.println("количество положительных чисел: " + positiveNumber);
    }
}
