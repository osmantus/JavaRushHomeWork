package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        int id = 0;

        int paramID = Integer.parseInt(args[1]);

        String productName = "";
        String price = "";
        String quantity = "";

        if (args[0].equals("-u"))
        {
            productName = args[2];
            if (productName.length() < 30)
            {
                int charsToAdd = 30 - productName.length();
                StringBuffer sBuffer = new StringBuffer(productName);
                for (int i = 0; i < charsToAdd; i++)
                    sBuffer.append(" ");
                productName = sBuffer.substring(0);
            } else if (productName.length() > 30)
            {
                productName = productName.substring(0, 8);
            }

            price = args[3];
            if (price.length() < 8)
            {
                int charsToAdd = 8 - price.length();
                StringBuffer sBuffer = new StringBuffer(price);
                for (int i = 0; i < charsToAdd; i++)
                    sBuffer.append(" ");
                price = sBuffer.substring(0);
            } else if (price.length() > 8)
            {
                price = price.substring(0, 8);
            }

            quantity = args[4];
            if (quantity.length() < 4)
            {
                int charsToAdd = 4 - quantity.length();
                StringBuffer sBuffer = new StringBuffer(quantity);
                for (int i = 0; i < charsToAdd; i++)
                    sBuffer.append(" ");
                quantity = sBuffer.substring(0);
            } else if (quantity.length() > 4)
            {
                quantity = quantity.substring(0, 4);
            }
        }

        BufferedReader reader1 = new BufferedReader(new FileReader(fileName));
        String rr;

        String tmpFileName = fileName.concat(".tmp");
        BufferedWriter bw = new BufferedWriter(new FileWriter(tmpFileName));

        while ((rr = reader1.readLine()) != null)
        {
            try
            {
                id = Integer.parseInt(rr.substring(0, 8).trim());
                if (args[0].equals("-u"))
                {
                    if (id == paramID)
                    {
                        rr = rr.replace(rr.substring(8), productName.concat(price.concat(quantity)));
                        bw.write(rr);
                        bw.newLine();
                    } else
                    {
                        bw.write(rr);
                        bw.newLine();
                    }
                }
                else if (args[0].equals("-d"))
                {
                    if (id != paramID)
                    {
                        bw.write(rr);
                        bw.newLine();
                    }
                }
            }
            catch (NumberFormatException e)
            {
            }
            catch (StringIndexOutOfBoundsException e)
            {
            }
        }

        reader1.close();
        bw.close();

        File oldFile = new File(fileName);
        oldFile.delete();

        File updatedFile = new File(tmpFileName);
        updatedFile.renameTo(oldFile);
    }
}
