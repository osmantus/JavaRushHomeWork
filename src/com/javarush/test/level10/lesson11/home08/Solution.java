package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList<String> arrayElement;
        ArrayList<String>[] arrayOfLists = new ArrayList[3];

        for (int i = 0; i < 3; i++)
        {
            arrayElement = new ArrayList<String>();
            for (int j = 0; j < 3; j++)
                arrayElement.add(String.valueOf(j));

            arrayOfLists[i] = arrayElement;
        }

        if (arrayOfLists != null)
            return arrayOfLists;
        else
            return null;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}