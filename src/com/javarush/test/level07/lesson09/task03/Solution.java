package com.javarush.test.level07.lesson09.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Слово «именно»
1. Создай список из слов «мама», «мыла», «раму».
2. После каждого слова вставь в список строку, содержащую слово «именно».
3. Используя цикл for вывести результат на экран, каждый элемент списка с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> listString = new ArrayList<String>();
        listString.add("мама");
        listString.add("мыла");
        listString.add("раму");

        int startListLen = listString.size();
        int addedStrCounter = 0;
        for (int i = 0; i < startListLen; i++)
        {
            if (i > 0)
            {
                listString.add(i + addedStrCounter, "именно");
                addedStrCounter++;
            }
        }
        if (startListLen > 0)
            listString.add("именно");

        for (String str : listString)
            System.out.println(str);
    }
}
