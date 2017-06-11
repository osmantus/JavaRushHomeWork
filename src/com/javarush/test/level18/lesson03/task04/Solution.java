package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();

        if (!filePath.equals(""))
        {
            FileInputStream inputStream = new FileInputStream(filePath);
            if (inputStream != null)
            {
                int byteFromFile = 0;
                HashMap<Integer, Integer> bytesByNumber = new HashMap<>();
                Integer number = 0;
                while (inputStream.available() > 0)
                {
                    byteFromFile = inputStream.read();
                    if (bytesByNumber.containsKey(byteFromFile))
                    {
                        number = bytesByNumber.get(byteFromFile) + 1;
                        bytesByNumber.put(byteFromFile, number);
                    }
                    else
                        bytesByNumber.put(byteFromFile, 1);
                }

                ArrayList<Integer> minBytes = getMinBytesArray(bytesByNumber);
                if (!minBytes.isEmpty())
                {
                    for (Integer eachByte : minBytes)
                        System.out.print(eachByte + " ");
                }
                inputStream.close();
            }
        }
    }

    public static ArrayList<Integer> getMinBytesArray(HashMap<Integer, Integer> srcMap)
    {
        ArrayList<Integer> retBytes = new ArrayList<Integer>();
        Integer minNumber = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> mapEntry : srcMap.entrySet())
        {
            if (mapEntry.getValue() < minNumber)
                minNumber = mapEntry.getValue();
        }
        for (Map.Entry<Integer, Integer> mapEntry : srcMap.entrySet())
        {
            if (mapEntry.getValue() == minNumber)
                retBytes.add(mapEntry.getKey());
        }
        return retBytes;
    }
}
