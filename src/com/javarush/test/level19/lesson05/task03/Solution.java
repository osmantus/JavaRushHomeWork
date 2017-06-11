package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-com.javarush.test.level19.lesson10.home10.user.resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        String filePath1, filePath2;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        filePath1 = reader.readLine();
        filePath2 = reader.readLine();

        reader.close();

        FileReader fr = new FileReader(filePath1);

        FileWriter fw = new FileWriter(filePath2);
        String result = "";

        String subStr = "";
        char fileSymbol = 0;

        while (fr.ready())
        {
            fileSymbol = (char) fr.read();
            if (fileSymbol != ' ')
                subStr = subStr.concat(String.valueOf(fileSymbol));
            else
            {
                if (subStr.matches("[0-9]+"))
                {
                    result = result.concat(subStr.concat(" "));
                    subStr = "";
                } else
                    subStr = "";
            }
        }

        fw.write(result.trim());

        fr.close();
        fw.close();
    }
}
