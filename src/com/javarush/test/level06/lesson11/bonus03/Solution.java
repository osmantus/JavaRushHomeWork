package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        //ArrayList<Integer> arrayInt = new ArrayList<>();
        int[] arrayInt = new int[5];
        for (int i = 0; i < 5; i++)
        {
            int number = Integer.parseInt(reader.readLine());
            //arrayInt.add(number);
            arrayInt[i] = number;
        }
        Arrays.sort(arrayInt);
        for (int i = 0; i < 5; i++)
            System.out.println(arrayInt[i]);
    }
}
