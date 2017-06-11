package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-com.javarush.test.level19.lesson10.home10.user.resources
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        String fileName = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream outFileStream = null;
        FileInputStream inFileStream = null;

        String firstName = null;
        String strPart = null;
        int fileLen = 0;

        ArrayList<String> arrayList = new ArrayList<>();
        SortedMap<Integer, String> fileNames = new TreeMap<>();

        int subStrPos = 0;

        while (!(fileName = reader.readLine()).equals("end")) {
            subStrPos = fileName.lastIndexOf(".part");

            if (firstName == null)
                firstName = fileName.substring(0, subStrPos);

            strPart = fileName.substring(subStrPos);
            strPart = strPart.replaceAll(".part", "");
            if (!strPart.equals(""))
                fileNames.put(Integer.valueOf(strPart), fileName);
        }

        reader.close();

        if (!firstName.equals(""))
        {
            try
            {
                outFileStream = new FileOutputStream(firstName);

                for (Map.Entry<Integer, String> eachItem : fileNames.entrySet())
                {
                    fileName = eachItem.getValue();
                    if (!fileName.equals(""))
                    {
                        inFileStream = new FileInputStream(fileName);
                        fileLen = inFileStream.available();
                        byte[] arrayChars = new byte[fileLen];

                        if (inFileStream.read(arrayChars) > 0)
                        {
                            outFileStream.write(arrayChars);
                            inFileStream.close();
                        }
                    }
                }

                outFileStream.close();
            }
            catch (FileNotFoundException e)
            {}
            finally
            {
                outFileStream.flush();
                outFileStream.close();
                inFileStream.close();
            }
        }
    }
}
