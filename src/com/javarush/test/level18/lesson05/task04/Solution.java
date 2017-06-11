package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-com.javarush.test.level19.lesson10.home10.user.resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath1 = reader.readLine();
        String filePath2 = reader.readLine();

        if (!filePath1.equals(""))
        {
            FileInputStream inputStream1 = new FileInputStream(filePath1);
            if (inputStream1 != null)
            {
                File srcFile = new File(filePath1);
                byte[] buffer = new byte[(int) srcFile.length()];
                int fileRealLen = 0;
                byte[] revBuffer = new byte[(int) srcFile.length()];

                if (inputStream1.available() > 0)
                {
                    fileRealLen = inputStream1.read(buffer);
                    int j = 0;
                    for (int i = fileRealLen-1; i >= 0; i--)
                    {
                        revBuffer[j] = buffer[i];
                        j++;
                    }

                    FileOutputStream outputStream1 = new FileOutputStream(filePath2);
                    outputStream1.write(revBuffer);

                    inputStream1.close();
                    outputStream1.close();
                    reader.close();
                }
            }
        }
    }
}
