package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-com.javarush.test.level19.lesson10.home10.user.resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {

        if (!args[0].equals(""))
        {
            String filePath1 = args[0];

            FileInputStream inputStream1 = new FileInputStream(filePath1);

            TreeMap<Integer, Integer> charsMap = new TreeMap<>();
            Integer charFromFile;
            Integer charNumber;

            while (inputStream1.available() > 0)
            {
                charFromFile = inputStream1.read();

                if (!charsMap.containsKey(charFromFile))
                {
                    charsMap.put(charFromFile, 1);
                }
                else
                {
                    charNumber = charsMap.get(charFromFile) + 1;
                    charsMap.put(charFromFile, charNumber);
                }
            }

            String key;

            for (Map.Entry<Integer, Integer> item : charsMap.entrySet())
            {
                key = Character.toString((char)(int)item.getKey());

                System.out.println(key + " " + item.getValue());
            }

            inputStream1.close();
        }
    }
}
