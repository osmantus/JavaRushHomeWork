package com.javarush.test.level08.lesson11.home04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Минимальное из N чисел
1. Ввести с клавиатуры число N.
2. Считать N целых чисел и заполнить ими список - метод getIntegerList.
3. Найти минимальное число среди элементов списка - метод getMinimum.
*/

public class Solution
{
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {

        int min = Integer.MIN_VALUE;
        if (!array.isEmpty())
        {
            min = array.get(0);
            for (Integer item : array)
            {
                if (item < min)
                    min = item;
            }
        }
        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {

        List<Integer> intList = new LinkedList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        String anyStr;
        Integer number;
        for (int i = 0; i < N; i++)
        {
            anyStr = reader.readLine();
            if (!anyStr.isEmpty())
            {
                number = Integer.parseInt(anyStr);
                intList.add(number);
            }
        }

        if (!intList.isEmpty())
            return intList;
        else
            return null;
    }
}
