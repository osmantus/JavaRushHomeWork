package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        Map<Integer, String> mapStr = new TreeMap<Integer, String>();
        Map<Integer, String> mapInt = new TreeMap<Integer, String>();

        for (int i = 0; i < array.length; i++)
        {
            if (isNumber(array[i]))
                mapInt.put(i, array[i]);
            else
                mapStr.put(i, array[i]);
        }

        String[] newStrArray = new String[array.length];
        String[] newIntArray = new String[array.length];
        int index = 0, prevIndex = 0;

        for (Map.Entry<Integer, String> item : mapInt.entrySet())
        {
            newIntArray[item.getKey()] = item.getValue();
        }

        String prevItem = "", curItem = "";
        for (int i = 0; i < newIntArray.length; i++)
        {
            if (newIntArray[i] != null)
            {
                prevItem = "";
                for (Map.Entry<Integer, String> item : mapInt.entrySet())
                {
                    index = item.getKey();
                    curItem = newIntArray[index];
                    if (!prevItem.equals(""))
                    {
                        if (Double.parseDouble(curItem) > Double.parseDouble(prevItem))
                        {
                            newIntArray[prevIndex] = curItem;
                            newIntArray[index] = prevItem;
                        }
                    }
                    else
                    {
                        if (newIntArray[index] == null)
                            newIntArray[index] = curItem;
                    }

                    prevItem = newIntArray[index];
                    prevIndex = index;
                }
            }
        }

        index = 0;
        prevIndex = 0;

        for (Map.Entry<Integer, String> item : mapStr.entrySet())
        {
            newStrArray[item.getKey()] = item.getValue();
        }

        prevItem = "";
        curItem = "";
        for (int i = 0; i < newStrArray.length; i++)
        {
            if (newStrArray[i] != null)
            {
                prevItem = "";
                for (Map.Entry<Integer, String> item : mapStr.entrySet())
                {
                    index = item.getKey();
                    curItem = newStrArray[index];
                    if (!prevItem.equals(""))
                    {
                        if (!isGreaterThan(curItem, prevItem))
                        {
                            newStrArray[prevIndex] = curItem;
                            newStrArray[index] = prevItem;
                        }
                    }
                    else
                    {
                        if (newStrArray[index] == null)
                            newStrArray[index] = curItem;
                    }

                    prevItem = newStrArray[index];
                    prevIndex = index;
                }
            }
        }

        for (int i = 0; i < array.length; i++)
        {
            if (newIntArray[i] != null)
                array[i] = newIntArray[i];
            else if (newStrArray[i] != null)
                array[i] = newStrArray[i];
        }

    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }

    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
