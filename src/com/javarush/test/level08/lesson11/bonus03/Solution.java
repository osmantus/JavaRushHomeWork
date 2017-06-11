package com.javarush.test.level08.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

/* Задача по алгоритмам
Задача: Введи с клавиатуры 20 слов и выведи их в алфавитном порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        /*SortedSet<String> sortedSet = new TreeSet<String>();

        for (int i = 0; i < array.length; i++)
        {
            sortedSet.add(array[i]);
        }

        if (!sortedSet.isEmpty())
        {
            int i = 0;
            for (String item : sortedSet)
            {
                if (i < array.length)
                {
                    array[i] = item;
                    i++;
                }
            }
        }*/

        String prevStr, curStr = "";
        for (int j = 0; j < array.length; j++)
        {
            prevStr = array[0];
            for (int i = 1; i < array.length; i++)
            {
                curStr = array[i];
                if (isGreaterThan(prevStr, curStr))
                {
                    array[i-1] = curStr;
                    array[i] = prevStr;
                }
                prevStr = array[i];
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }
}
