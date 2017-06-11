package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
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
                int minByte = Integer.MAX_VALUE;
                while (inputStream.available() > 0)
                {
                    byteFromFile = inputStream.read();
                    if (byteFromFile < minByte)
                    {
                        minByte = byteFromFile;
                    }
                }
                System.out.println(minByte);
            }
            inputStream.close();
        }

    }
}
