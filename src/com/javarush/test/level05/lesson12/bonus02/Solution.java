package com.javarush.test.level05.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два числа с клавиатуры и выводит минимальное из них на экран.
Новая задача: Программа вводит пять чисел с клавиатуры и выводит минимальное из них на экран.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a, b;
        int minimum;

        //int a = Integer.parseInt(reader.readLine());
        //int b = Integer.parseInt(reader.readLine());

        //minimum = min(a, b);

        //System.out.println("Minimum = " + minimum);

/*
        int cur_min, prev_min;

        int c = 0;
        c = Integer.parseInt(reader.readLine());
        minimum = prev_min = c;

        for (int i = 1; i <= 2; i++)
        {
           a = Integer.parseInt(reader.readLine());
           b = Integer.parseInt(reader.readLine());

           cur_min = min(a, b);
           if (cur_min < prev_min)
               minimum = cur_min;

           prev_min = cur_min;
        }
        //System.out.println("Minimum = " + minimum);
        System.out.println(minimum);
*/

        int c = 0;
        c = Integer.parseInt(reader.readLine());
        minimum = c;

        a = Integer.parseInt(reader.readLine());
        b = Integer.parseInt(reader.readLine());

        int minimum1 = min(a, b);

        a = Integer.parseInt(reader.readLine());
        b = Integer.parseInt(reader.readLine());

        int minimum2 = min(a, b);

        if (minimum1 < minimum)
            minimum = minimum1;
        if (minimum2 < minimum)
            minimum = minimum2;

        System.out.println("Minimum = " + minimum);
    }


    public static int min(int a, int b)
    {
        return a < b ? a : b;
    }

}
