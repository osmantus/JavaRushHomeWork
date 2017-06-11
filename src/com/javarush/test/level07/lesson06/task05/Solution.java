package com.javarush.test.level07.lesson06.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Удали последнюю строку и вставь её в начало
1. Создай список строк.
2. Добавь в него 5 строчек с клавиатуры.
3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
4. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> stringList = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++)
            stringList.add(reader.readLine());

        String anyStr;
        int strLen = stringList.size();
        for (int i = 0; i < 13; i++)
        {
            anyStr = stringList.get(strLen - 1);
            stringList.remove(strLen - 1);
            stringList.add(0, anyStr);
        }

        for (String eachStr : stringList)
            System.out.println(eachStr);
    }
}
