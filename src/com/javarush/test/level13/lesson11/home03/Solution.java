package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        InputStreamReader inStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inStreamReader);

        try
        {
            String fileName = reader.readLine();

            InputStream inStream = new FileInputStream(fileName);
            while (inStream.available() > 0)
            {
                System.out.print((char)inStream.read());
            }

            inStream.close();
            inStreamReader.close();
        }
        catch (IOException e)
        {
            inStreamReader.close();
            e.printStackTrace();
        }
    }
}
