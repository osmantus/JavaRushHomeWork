package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {

    final static int byteCodingOffset = 10;

    public static void main(String[] args) throws Exception
    {
        String switchKey = null;
        String inputFileName = null;
        String outputFileName = null;

        if (!args[0].equals("") && !args[1].equals("") && !args[2].equals(""))
        {
            switchKey = args[0];

            inputFileName = args[1];
            outputFileName = args[2];

            if (switchKey.equals("-e"))
            {
                encodeFile(inputFileName, outputFileName);
            }
            else if (switchKey.equals("-d"))
            {
                decodeFile(inputFileName, outputFileName);
            }
        }
    }

    public static void encodeFile(String srcFilePath, String destFilePath) throws Exception
    {
        if (!srcFilePath.equals("") && !destFilePath.equals(""))
        {
            FileInputStream inStream = new FileInputStream(srcFilePath);
            FileOutputStream outStream = new FileOutputStream(destFilePath);

            int fileByte = 0;

            if (inStream != null && outStream != null)
            {
                while (inStream.available() > 0)
                {
                    fileByte = inStream.read();
                    fileByte = fileByte + byteCodingOffset;
                    outStream.write(fileByte);
                }

                inStream.close();
                outStream.close();
            }
        }
    }

    public static void decodeFile(String srcFilePath, String destFilePath) throws Exception
    {
        if (!srcFilePath.equals("") && !destFilePath.equals(""))
        {
            FileInputStream inStream = new FileInputStream(srcFilePath);
            FileOutputStream outStream = new FileOutputStream(destFilePath);

            int fileByte = 0;

            if (inStream != null && outStream != null)
            {
                while (inStream.available() > 0)
                {
                    fileByte = inStream.read();
                    fileByte = fileByte - byteCodingOffset;
                    outStream.write(fileByte);
                }

                inStream.close();
                outStream.close();
            }
        }
    }
}
