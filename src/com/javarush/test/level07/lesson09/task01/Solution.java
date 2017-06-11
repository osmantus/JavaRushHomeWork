package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<Integer> intList = new ArrayList<Integer>();
        ArrayList<Integer> intListDiv3 = new ArrayList<Integer>();
        ArrayList<Integer> intListDiv2 = new ArrayList<Integer>();
        ArrayList<Integer> intListOthers = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++)
        {
            intList.add(Integer.parseInt(reader.readLine()));
        }

        for (int eachInt : intList)
        {
            if (eachInt % 3 == 0)
            {
                intListDiv3.add(eachInt);
                if (eachInt % 2 == 0)
                    intListDiv2.add(eachInt);
            }
            else if (eachInt % 2 == 0)
            {
                intListDiv2.add(eachInt);
                if (eachInt % 3 == 0)
                    intListDiv3.add(eachInt);
            }
            else
                intListOthers.add(eachInt);
        }

        printList(intListDiv3);
        System.out.println();
        printList(intListDiv2);
        System.out.println();
        printList(intListOthers);
    }

    public static void printList(List<Integer> list)
    {
        for (int eachElem : list)
            System.out.println(eachElem);
    }
}
