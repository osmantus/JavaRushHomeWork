package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-com.javarush.test.level19.lesson10.home10.user.resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {

        InputStreamReader inStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inStream);
        String filePath1 = reader.readLine();

        if (!args[0].equals(""))
        {
            int id = Integer.parseInt(args[0]);

            //FileInputStream inputStream1 = new FileInputStream(filePath1);
            BufferedReader readerFile = new BufferedReader(new FileReader(filePath1));

            String lineStr = "";

            while ((lineStr = readerFile.readLine()) != null)
            {
                if (lineStr.startsWith(args[0] + " "))
                    System.out.println(lineStr);
            }

            readerFile.close();

            /*
            int charFromFile = 0;

            HashSet<String> fileLinesSet = new HashSet<>();

            int idSearch = 0;
            String strFromFile = "";

            boolean isBeforeLineBreak = true;

            while (inputStream1.available() > 0)
            {
                charFromFile = inputStream1.read();

                if (charFromFile == 10 || charFromFile == 13)
                    isBeforeLineBreak = false;
                else
                    isBeforeLineBreak = true;

                if (isBeforeLineBreak)
                {
                    strFromFile = strFromFile + Character.toString((char) charFromFile);
                }
                else
                {
                    if (strFromFile != "")
                    {
                        fileLinesSet.add(strFromFile);
                        strFromFile = "";
                    }
                }
            }

            for (String eachStr : fileLinesSet)
            {
                if (eachStr.indexOf(" ") > 0)
                {
                    idSearch = Integer.parseInt(eachStr.substring(0, eachStr.indexOf(" ")));
                    if (idSearch == id)
                        System.out.println(eachStr);
                }
            }

            inputStream1.close();
            */
        }

        reader.close();
        inStream.close();
    }
}
