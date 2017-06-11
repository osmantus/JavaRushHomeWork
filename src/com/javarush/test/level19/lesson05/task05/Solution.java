package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
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

        String strChar = "";

        while (fr.ready())
        {
            fileSymbol = (char) fr.read();
            strChar = String.valueOf(fileSymbol);
            if ((strChar.matches("\\d") || strChar.matches("\\w")) && strChar.matches("\\S"))
                result = result.concat(strChar);
        }

        fw.write(result);

        fr.close();
        fw.close();
    }
}
