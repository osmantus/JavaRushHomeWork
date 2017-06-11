package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
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

        if (!filePath1.equals(""))
        {
            FileInputStream inputStream1 = new FileInputStream(filePath1);
            if (inputStream1 != null)
            {
                File srcFile = new File(filePath1);
                byte[] buffer = new byte[(int) srcFile.length()];
                int fileRealLen = 0;
                int firstHalfofLen = 0, secondHalfofLen = 0;

                if (inputStream1.available() > 0)
                {
                    fileRealLen = inputStream1.read(buffer);
                    secondHalfofLen = fileRealLen / 2;
                    firstHalfofLen = fileRealLen - secondHalfofLen;

                    FileOutputStream outputStream1 = new FileOutputStream(filePath2);
                    FileOutputStream outputStream2 = new FileOutputStream(filePath3);

                    outputStream1.write(buffer, 0, firstHalfofLen);
                    outputStream2.write(buffer, firstHalfofLen, secondHalfofLen);

                    inputStream1.close();
                    outputStream1.close();
                    outputStream2.close();
                    reader.close();
                }
            }
        }
    }
}
