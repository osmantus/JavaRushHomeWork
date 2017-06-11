package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String inputTxt1 = buffer.readLine();
        String inputTxt2 = buffer.readLine();

        Integer number1 = Integer.parseInt(inputTxt1);
        Integer number2 = Integer.parseInt(inputTxt2);

        if (number1 < number2)
            System.out.println(number1);
        else
            System.out.println(number2);
    }
}