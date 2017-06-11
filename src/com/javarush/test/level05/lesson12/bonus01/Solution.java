package com.javarush.test.level05.lesson12.bonus01;

import java.io.*;

/* Нужно исправить программу, чтобы компилировалась и работала
Задача: Программа вводит два числа с клавиатуры и выводит их сумму на экран.
*/

public class Solution
{
   public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputTxt1 = reader.readLine();
        String inputTxt2 = reader.readLine();

        //int a = reader.readLine();
        //int b = reader.read();

        int a = Integer.parseInt(inputTxt1);
        int b = Integer.parseInt(inputTxt2);

        int sum = a + b;
        System.out.println("Sum = " + sum);
    }
}
