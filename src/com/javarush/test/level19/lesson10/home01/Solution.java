package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-com.javarush.test.level19.lesson10.home10.user.resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        if (args[0].equals(""))
            return;

        String filePath = args[0];
        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
        /*Reader fileReader = new InputStreamReader(new FileInputStream(filePath), "utf-8");

        File file = new File(filePath);
        char[] charBuffer = new char[(int) file.length()];
        fileReader.read(charBuffer);*/

        String fileLine = "";
        String[] fileSubStrArray = null;

        String surName = null;
        Double nameValue = null;

        ArrayList<String[]> arrayList = new ArrayList<>();

        int index = 0;
        String[] strArray = null;

        /*
        int index = 0;
        String[] strArray = null;
        char symbol;

        while (index < charBuffer.length)
        {
            fileLine = "";
            symbol = charBuffer[index];
            while (symbol != '\n' && symbol != '\r')
            {
                fileLine = fileLine.concat(String.valueOf(symbol));
                index++;
                if (index == charBuffer.length)
                    break;
                symbol = charBuffer[index];
            }
            if (index < charBuffer.length)
            {
                index++;
                symbol = charBuffer[index];
                if (symbol == '\n' || symbol == '\r')
                    index++;
            }

            fileSubStrArray = fileLine.split(" ");
            if (fileSubStrArray.length == 2)
            {
                strArray = new String[2];
                strArray[0] = fileSubStrArray[0];
                strArray[1] = fileSubStrArray[1];
                arrayList.add(strArray);
            }
        }*/

        /*while (fileReader.ready())
        {
            fileLine = "";
            symbol = (char) fileReader.read();
            while (symbol != '\n' && symbol != '\r')
            {
                fileLine = fileLine.concat(String.valueOf(symbol));
            }

            //fileLine = fileReader.readLine();
            fileSubStrArray = fileLine.split(" ");
            if (fileSubStrArray.length == 2)
            {
                strArray = new String[2];
                strArray[0] = fileSubStrArray[0];
                strArray[1] = fileSubStrArray[1];
                arrayList.add(strArray);
            }
            index++;
        }*/

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

        for (String eachItem : sortedSet)
            System.out.println(eachItem + " " + summaryMap.get(eachItem));

        fileReader.close();
    }
}
