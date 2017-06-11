package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        InputStreamReader inStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inStreamReader);
        OutputStream outStream;

        try
        {
            String fileName = reader.readLine();
            if (!fileName.equals(""))
            {
                ArrayList<String> arrayList = new ArrayList<String>();

                outStream = new FileOutputStream(fileName);
                if (outStream != null)
                {
                /*String InputStr = "";
                while (true)
                {
                    InputStr = reader.readLine();
                    if (InputStr.equals("exit"))
                        break;
                    outStream.write(InputStr.getBytes());
                    outStream.write('\n');
                }*/

                    String InputStr = "";
                    while (true)
                    {
                        InputStr = reader.readLine();
                        arrayList.add(InputStr);

                        if (InputStr.equals("exit"))
                            break;
                    }

                    for (String item : arrayList)
                    {
                        outStream.write(item.getBytes());
                        outStream.write('\n');
                    }

                    outStream.close();
                }

            /*String InputStr = "";
            while (true)
            {
                InputStr = reader.readLine();
                if (InputStr.equals("exit"))
                    break;
                outStream.write(InputStr.getBytes());
                outStream.write('\n');
            }*/

                inStreamReader.close();
            }
        }
        catch (IOException e)
        {
            inStreamReader.close();
            e.printStackTrace();
        }
    }
}
