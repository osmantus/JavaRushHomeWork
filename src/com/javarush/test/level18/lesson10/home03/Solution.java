package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-com.javarush.test.level19.lesson10.home10.user.resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath1 = reader.readLine();
        String filePath2 = reader.readLine();
        String filePath3 = reader.readLine();

        if (!filePath1.equals("") && !filePath2.equals("") && !filePath3.equals(""))
        {
            FileOutputStream outputStream1 = new FileOutputStream(filePath1);
            FileInputStream inputStream2 = new FileInputStream(filePath2);
            FileInputStream inputStream3 = new FileInputStream(filePath3);

            if (outputStream1 != null && inputStream2 != null && inputStream3 != null)
            {
                File srcFile = new File(filePath2);
                byte[] bytesArray = new byte[(int) srcFile.length()];

                inputStream2.read(bytesArray);
                outputStream1.write(bytesArray);

                int file3Len = inputStream3.available();
                if (file3Len > 0)
                {
                    File destFile = new File(filePath1);
                    int file1Len = (int) destFile.length();

                    bytesArray = new byte[file3Len];
                    inputStream3.read(bytesArray);

                    outputStream1.write(bytesArray);
                }
            }

            outputStream1.close();
            inputStream2.close();
            inputStream3.close();
        }
        reader.close();
    }
}
