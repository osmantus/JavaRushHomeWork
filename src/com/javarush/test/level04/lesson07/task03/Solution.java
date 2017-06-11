package com.javarush.test.level04.lesson07.task03;

/* Положительные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел в исходном наборе.
Пример для чисел -4 6 6:
2
Пример для чисел -6 -6 -3:
0
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

        if (number1 != 0 && number2 != 0 && number3 != 0)
        {
            if (number1 > 0 && number2 > 0 && number3 > 0)
                System.out.println("3");
            else if (number1 > 0 && number2 > 0 && number3 < 0)
                System.out.println("2");
            else if (number1 > 0 && number2 < 0 && number3 < 0)
                System.out.println("1");
            else if (number1 < 0 && number2 < 0 && number3 < 0)
                System.out.println("0");
            else if (number1 < 0 && number2 < 0 && number3 > 0)
                System.out.println("1");
            else if (number1 < 0 && number2 > 0 && number3 > 0)
                System.out.println("2");
            else if (number1 < 0 && number2 > 0 && number3 < 0)
                System.out.println("1");
            else if (number1 > 0 && number2 < 0 && number3 > 0)
                System.out.println("2");
        }
        else if (number1 == 0 && number2 != 0 && number3 != 0)
        {
            if (number2 > 0 && number3 > 0)
                System.out.println("2");
            else if (number2 > 0 && number3 < 0)
                System.out.println("1");
            else if (number2 < 0 && number3 < 0)
                System.out.println("0");
            else if (number2 < 0 && number3 > 0)
                System.out.println("1");
        }
        else if (number1 != 0 && number2 != 0 && number3 == 0)
        {
            if (number1 > 0 && number2 > 0)
                System.out.println("2");
            else if (number1 > 0 && number2 < 0)
                System.out.println("1");
            else if (number1 < 0 && number2 < 0)
                System.out.println("0");
            else if (number1 < 0 && number2 > 0)
                System.out.println("1");
        }
        else if (number1 != 0 && number2 == 0 && number3 != 0)
        {
            if (number1 > 0 && number3 > 0)
                System.out.println("2");
            else if (number1 > 0 && number3 < 0)
                System.out.println("1");
            else if (number1 < 0 && number3 < 0)
                System.out.println("0");
            else if (number1 < 0 && number3 > 0)
                System.out.println("1");
        }
        else if (number1 == 0 && number2 == 0 && number3 != 0)
        {
            System.out.println("1");
        }
        else if (number1 == 0 && number2 != 0 && number3 == 0)
        {
            System.out.println("1");
        }
        else if (number1 != 0 && number2 == 0 && number3 == 0)
        {
            System.out.println("1");
        }
    }
}
