package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-com.javarush.test.level19.lesson10.home10.user.resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        if (!args[0].equals("") && !args[1].equals(""))
        {
            String inFilePath = args[0];
            String outFilePath = args[1];
            BufferedReader br = new BufferedReader(new FileReader(inFilePath));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outFilePath));

            String fileLine = "";
            String[] wordsArray = null;
            char[] buffer;

            while (br.ready())
            {
                fileLine = br.readLine();
                wordsArray = fileLine.split(" ");

                for (int i = 0; i < wordsArray.length; i++)
                {
                    buffer = wordsArray[i].toCharArray();
                    for (int j = 0; j < buffer.length; j++)
                    {
                        if (buffer[j] >= 48 && buffer[j] < 57)
                        {
                            bw.write(buffer);
                            bw.write(" ");
                            break;
                        }
                    }
                }

            }
            br.close();
            bw.close();
        }
    }
}
