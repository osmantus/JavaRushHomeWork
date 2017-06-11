package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-com.javarush.test.level19.lesson10.home10.user.resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath1 = reader.readLine();
        String filePath2 = reader.readLine();

        if (!filePath1.equals("") && !filePath2.equals(""))
        {
            FileInputStream inputStream2 = new FileInputStream(filePath2);
            FileInputStream inputStream3 = new FileInputStream(filePath1);
            byte[] bytesArray2, bytesArray3;

            if (inputStream2 != null && inputStream3 != null)
            {
                bytesArray3 = new byte[inputStream3.available()];
                inputStream3.read(bytesArray3);
                inputStream3.close();

                FileOutputStream outputStream1 = new FileOutputStream(filePath1);
                if (outputStream1 != null)
                {
                    bytesArray2 = new byte[inputStream2.available()];

                    inputStream2.read(bytesArray2, 0, inputStream2.available());
                    outputStream1.write(bytesArray2);
                    outputStream1.write(bytesArray3);

                    outputStream1.close();
                }
            }

            inputStream2.close();
        }
        reader.close();
    }
}
