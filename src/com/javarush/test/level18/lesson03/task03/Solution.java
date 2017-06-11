package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
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
                HashMap<Integer, Integer> resMap = getMaxBytesMap(bytesByNumber);
                if (!resMap.isEmpty())
                {
                    for (Map.Entry<Integer, Integer> mapEntry : resMap.entrySet())
                        System.out.print(mapEntry.getKey() + " ");
                }
            }
            inputStream.close();
        }

    }

    public static HashMap<Integer, Integer> getMaxBytesMap(HashMap<Integer, Integer> srcMap)
    {
        HashMap<Integer, Integer> retMap = new HashMap<>();
        Integer maxNumber = 0;
        for (Map.Entry<Integer, Integer> mapEntry : srcMap.entrySet())
        {
            if (mapEntry.getValue() > maxNumber)
                maxNumber = mapEntry.getValue();
        }
        for (Map.Entry<Integer, Integer> mapEntry : srcMap.entrySet())
        {
            if (mapEntry.getValue() == maxNumber)
                retMap.put(mapEntry.getKey(), mapEntry.getValue());
        }
        return retMap;
    }
}
