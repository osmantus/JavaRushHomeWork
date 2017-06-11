package com.javarush.test.level04.lesson06.task07;

/* Три числа
Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой.
Вывести на экран порядковый номер числа, отличного от остальных.
Пример для чисел 4 6 6:
1
Пример для чисел 6 6 3:
3
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

        if (number1 == number2 && number1 != number3)
        {
            System.out.println(3);
        }
        else if (number1 == number3 && number1 != number2)
        {
            System.out.println(2);
        }
        else if (number2 == number3 && number2 != number1)
        {
            System.out.println(1);
        }
    }
}
