package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        if (!fileName.equals(""))
        {
            InputStream inStream = new FileInputStream(fileName);
            SortedSet<Integer> sortedSet = new TreeSet<Integer>();
            Integer number = 0;

            char symbol = 0;
            String str = "";

            if (inStream != null)
            {
                while (inStream.available() > 0)
                {
                    try
                    {
                        symbol = (char) inStream.read();
                        if (symbol != '\n')
                        {
                            str = str + String.valueOf(symbol);
                        }
                        else
                        {
                            //number = Integer.parseInt(String.valueOf(symbol));
                            number = Integer.parseInt(str);
                            str = "";
                            if (number % 2 == 0)
                                sortedSet.add(number);
                        }
                    }
                    catch (Exception e)
                    {}
                }
                if (!str.equals("") && symbol != '\n')
                {
                    number = Integer.parseInt(str);
                    if (number % 2 == 0)
                        sortedSet.add(number);
                }
            }

            for (Integer item : sortedSet)
            {
                System.out.println(item);
            }
        }
    }
}
