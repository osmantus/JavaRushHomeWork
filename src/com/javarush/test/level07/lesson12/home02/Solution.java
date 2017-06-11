package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < N; i++)
        {
            list.add(reader.readLine());
        }

        ArrayList<String> result = new ArrayList<String>();
        String tmpStr = "";
        int j = 0;
        result.addAll(list);

        for (int i = M-1; i >= 0; i--)
        {
            //tmpStr = result.get(i);
            //result.remove(i);
            //j++;
            //result.add(N-j-1, tmpStr);
            //result.add(N-1, result.get(i));
            //result.remove(i);

            tmpStr = result.get(i);
            result.remove(i);
            j++;
            if (i == M-1)
                result.add(tmpStr);
            else
                result.add(N-j, tmpStr);
        }

        for (int i = 0; i < result.size(); i++)
        {
            System.out.println(result.get(i));
        }
    }
}
