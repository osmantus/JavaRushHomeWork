package com.javarush.test.level07.lesson06.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая короткая строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> stringList = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++)
            stringList.add(reader.readLine());

        int len = stringList.get(0).length();
        String minLengthStr = "";

        for (int i = 0; i < stringList.size(); i++)
        {
            if (stringList.get(i).length() < len)
            {
                len = stringList.get(i).length();
                minLengthStr = stringList.get(i);
            }
        }

        //System.out.println(minLengthStr);

        for (int i = 0; i < stringList.size(); i++)
        {
            if (stringList.get(i).length() == len)
                System.out.println(stringList.get(i));
        }
    }
}
