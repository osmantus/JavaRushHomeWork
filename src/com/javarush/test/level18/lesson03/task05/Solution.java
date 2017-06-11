package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();

        if (!filePath.equals(""))
        {
            FileInputStream inputStream = new FileInputStream(filePath);
            if (inputStream != null)
            {
                int byteFromFile = 0;
                ArrayList<Integer> bytesList = new ArrayList<Integer>();
                Integer number = 0;
                while (inputStream.available() > 0)
                {
                    byteFromFile = inputStream.read();

                    if (!bytesList.contains(byteFromFile))
                        bytesList.add(byteFromFile);
                }

                sortArray(bytesList);
                for (Integer item : bytesList)
                    System.out.print(item + " ");

                inputStream.close();
            }
        }
    }

    public static void sortArray(ArrayList<Integer> srcArray)
    {
        Integer tmpValue = 0;
        for (int i = 0; i < srcArray.size()-1; i++)
        {
            boolean swapped = false;
            for (int j = 0; j < srcArray.size()-i-1; j++)
            {
                if (srcArray.get(j) > srcArray.get(j+1))
                {
                    tmpValue = srcArray.get(j);
                    srcArray.set(j, srcArray.get(j+1));
                    srcArray.set(j+1, tmpValue);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }
}
