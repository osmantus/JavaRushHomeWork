package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    static HashSet<Integer> myStaticSet;

    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> mySet = new HashSet<Integer>();
        for (int i = 0; i < 20; i++)
        {
            mySet.add(i);
        }
        return mySet;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        HashSet<Integer> myEditedSet = new HashSet<Integer>();
        for (Integer item : set)
        {
            if (item.intValue() <= 10)
                myEditedSet.add(item);
        }
        return myEditedSet;
    }

    public static void main(String[] args)
    {
        HashSet<Integer> myStaticSet = createSet();
        if (!myStaticSet.isEmpty())
            myStaticSet = removeAllNumbersMoreThan10(myStaticSet);
    }
}
