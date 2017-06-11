package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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

        Integer number1 = Integer.parseInt(inputTxt1);
        Integer number2 = Integer.parseInt(inputTxt2);
        Integer number3 = Integer.parseInt(inputTxt3);

        if (number2 > number1)
        {
            if (number3 > number2)
            {
                System.out.println(number3);
                System.out.println(number2);
                System.out.println(number1);
            }
            else
            {
                if (number3 > number1)
                {
                    System.out.println(number2);
                    System.out.println(number3);
                    System.out.println(number1);
                }
                else
                {
                    System.out.println(number2);
                    System.out.println(number1);
                    System.out.println(number3);
                }
            }
        }
        else
        {
            if (number3 > number1)
            {
                System.out.println(number3);
                System.out.println(number1);
                System.out.println(number2);
            }
            else
            {
                if (number3 > number2)
                {
                    System.out.println(number1);
                    System.out.println(number3);
                    System.out.println(number2);
                }
                else
                {
                    System.out.println(number1);
                    System.out.println(number2);
                    System.out.println(number3);
                }
            }
        }
    }
}
