package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-com.javarush.test.level19.lesson10.home10.user.resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

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
        char fileSymbol = 0;

        while (fr.ready())
        {
            fileSymbol = (char) fr.read();
            if (fileSymbol != '.')
                result = result.concat(String.valueOf(fileSymbol));
            else
                result = result.concat("!");
        }

        fw.write(result);

        fr.close();
        fw.close();
    }
}
