package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String inputTxt;
        int number = 0;
        int sum = 0;

        while (number != -1)
        {
            inputTxt = buffer.readLine();
            number = Integer.parseInt(inputTxt);

            sum = sum + number;
        }

        System.out.println(sum);
    }
}
