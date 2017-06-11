package com.javarush.test.level26.lesson02.task01;

import java.util.*;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        //implement logic here

        if (array.length > 0)
        {
            Arrays.sort(array, new Comparator<Integer>()
            {
                @Override
                public int compare(Integer o1, Integer o2)
                {
                    return o1 - o2;
                }
            });

            int len = array.length;
            Double avgDouble = null;

            if (len % 2 == 1)
            {
                avgDouble = new Double(array[len / 2]);
            } else
            {
                Integer int1 = array[len / 2 - 1];
                Integer int2 = array[len / 2];
                avgDouble = new Double((double) (int1 + int2) / 2.0);
            }

            final Double finalAvgDouble = avgDouble;

            Arrays.sort(array, new Comparator<Integer>()
            {
                @Override
                public int compare(Integer o1, Integer o2)
                {
                    int distanceObj1 = new Integer(Math.abs(o1 - (int) (Math.round(finalAvgDouble))));
                    int distanceObj2 = new Integer(Math.abs(o2 - (int) (Math.round(finalAvgDouble))));

                    if (distanceObj1 == distanceObj2)
                    {
                        return o1 - o2;
                    } else
                        return distanceObj1 - distanceObj2;
                }
            });

        }
        return array;
    }

    public static void main(String[] args)
    {
        Integer[] intArray = new Integer[] {7, 3, 5, 1};

        Integer[] resultArray = sort(intArray);
    }
}
