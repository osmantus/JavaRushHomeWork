package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки
2.2 выбросить исключение DownloadException
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = "";

        while (true)
        {
            try
            {
                filePath = reader.readLine();
                if (!filePath.equals(""))
                {
                    File srcFile = new File(filePath);
                    if (srcFile.length() < 1000)
                    {
                        reader.close();
                        throw new DownloadException();
                    }
                }
            }
            catch (Exception e)
            {
                throw (DownloadException) e;
            }
        }
    }

    public static class DownloadException extends Exception{

    }
}
