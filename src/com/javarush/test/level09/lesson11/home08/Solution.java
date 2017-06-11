package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        ArrayList<int[]> arrayIntArrays = new ArrayList<int[]>();

        int[] array1 = {1, 2, 3, 4, 5};
        arrayIntArrays.add(array1);

        int[] array2 = {1, 2};
        arrayIntArrays.add(array2);

        int[] array3 = {1, 2, 3, 4};
        arrayIntArrays.add(array3);

        int[] array4 = {1, 2, 3, 4, 5, 6, 7};
        arrayIntArrays.add(array4);

        int[] array5 = {};
        arrayIntArrays.add(array5);

        return arrayIntArrays;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
