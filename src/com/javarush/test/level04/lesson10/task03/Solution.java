package com.javarush.test.level04.lesson10.task03;

import java.io.*;

/* Хорошего не бывает много
Ввести с клавиатуры строку и число N.
Вывести на экран строку N раз используя цикл while.
Пример ввода:
абв
2
Пример вывода:
абв
абв
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String inputTxt1 = buffer.readLine();
        String inputTxt2 = buffer.readLine();

        int number = Integer.parseInt(inputTxt2);

        int i = 1;
        while (i <= number)
        {
            System.out.println(inputTxt1);
            i++;
        }
    }
}
