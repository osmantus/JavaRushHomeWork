package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
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
        String inputTxt4 = buffer.readLine();

        Integer number1 = Integer.parseInt(inputTxt1);
        Integer number2 = Integer.parseInt(inputTxt2);
        Integer number3 = Integer.parseInt(inputTxt3);
        Integer number4 = Integer.parseInt(inputTxt4);

        if (number2 > number1)
            if (number3 > number2)
            {
                if (number4 > number3)
                    System.out.println(number4);
                else
                    System.out.println(number3);
            }
            else
            {
                if (number4 > number2)
                    System.out.println(number4);
                else
                    System.out.println(number2);
            }
        else
        {
            if (number3 > number1)
            {
                if (number4 > number3)
                    System.out.println(number4);
                else
                    System.out.println(number3);
            }
            else
            {
                if (number4 > number1)
                    System.out.println(number4);
                else
                    System.out.println(number1);
            }
        }
    }
}
