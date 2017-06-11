package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-com.javarush.test.level19.lesson10.home10.user.resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {

        if (args[0].equals(""))
            return;

        String filePath = args[0];
        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));

        String fileLine = "";
        String[] fileSubStrArray = null;

        String surName = null;
        Double nameValue = null;

        ArrayList<String[]> arrayList = new ArrayList<>();

        int index = 0;
        String[] strArray = null;

        while (fileReader.ready())
        {
            fileLine = fileReader.readLine();
            fileSubStrArray = fileLine.split(" ");
            if (fileSubStrArray.length == 2)
            {
                strArray = new String[2];
                strArray[0] = fileSubStrArray[0];
                strArray[1] = fileSubStrArray[1];
                arrayList.add(strArray);
            }
            index++;
        }

        HashMap<String, Double> summaryMap = new HashMap<>();
        String key = null;
        Double value = null;
        Double curValue = null;

        for (int i = 0; i < arrayList.size(); i++)
        {
            strArray = arrayList.get(i);
            key = strArray[0];
            value = Double.valueOf(strArray[1]);

            if (!summaryMap.containsKey(key))
                summaryMap.put(key, value);
            else
            {
                curValue = summaryMap.get(key);
                summaryMap.remove(key);
                summaryMap.put(key, curValue + value);
            }
        }

        SortedSet<String> sortedSet = new TreeSet<String>(summaryMap.keySet());

        Double maxValue = summaryMap.get(key);
        String keyOfMaxValue = null;
        for (String eachItem : sortedSet)
        {
            curValue = summaryMap.get(eachItem);
            if (curValue > maxValue)
            {
                maxValue = curValue;
                keyOfMaxValue = eachItem;
            }
        }

        System.out.println(keyOfMaxValue);

        fileReader.close();
    }
}
