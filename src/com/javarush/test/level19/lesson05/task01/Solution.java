package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        String filePath1, filePath2;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        filePath1 = reader.readLine();
        filePath2 = reader.readLine();

        File file1 = new File(filePath1);
        File file2 = new File(filePath2);

        boolean isFileExist = false;

        if (file1.exists())
        {
            FileReader fileReader = new FileReader(filePath1);

            if (!file2.exists())
                isFileExist = file2.createNewFile();
            else
            {
                file2.delete();
                isFileExist = file2.createNewFile();
            }

            if (isFileExist)
            {
                FileWriter fileWriter = new FileWriter(filePath2);
                int fileByte = 0;
                int index = 1;

                while (fileReader.ready())
                {
                    fileByte = fileReader.read();
                    if (index % 2 == 0)
                    {
                        fileWriter.write(fileByte);
                    }
                    index++;
                }
                fileWriter.close();
            }
            fileReader.close();
        }
    }
}
