package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
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

        int len = 0;
        String maxLengthStr = "";
        for (String eachString : stringList)
        {
            if (eachString.length() > len)
            {
                len = eachString.length();
                maxLengthStr = eachString;
            }
        }

        //System.out.println(maxLengthStr);

        //ArrayList<String> maxLengthStrArray = new ArrayList<String>();
        for (int i = 0; i < stringList.size(); i++)
        {
            if (stringList.get(i).equals(maxLengthStr))
                //maxLengthStrArray.add()
                System.out.println(stringList.get(i));
        }
    }
}
