package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-com.javarush.test.level19.lesson10.home10.user.resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        if (!args[0].equals("") && !args[1].equals(""))
        {
            final char UTF8Flag = '\uFEFF';
            final char charSpace = '\u0020';

            String inFilePath = args[0];
            String outFilePath = args[1];

            BufferedReader br = new BufferedReader(new FileReader(inFilePath));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outFilePath));

            String fileLine = "";
            String[] wordsArray = null;

            int index = 0;
            while (br.ready())
            {
                fileLine = br.readLine();
                fileLine = fileLine.replace(UTF8Flag, charSpace).trim();

                wordsArray = fileLine.split(" ");

                for (int i = 0; i < wordsArray.length; i++)
                {
                    if (wordsArray[i].length() > 6)
                    {
                        if (index == 0)
                            bw.write(wordsArray[i]);
                        else
                            bw.write(",".concat(wordsArray[i]));
                        index++;
                    }
                }
            }
            br.close();
            bw.close();
        }
    }
}
