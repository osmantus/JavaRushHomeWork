package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-com.javarush.test.level19.lesson10.home10.user.resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath1 = reader.readLine();
        String filePath2 = reader.readLine();

        if (!filePath1.equals("") && !filePath2.equals(""))
        {
            FileInputStream inputStream1 = new FileInputStream(filePath1);
            FileOutputStream outputStream2 = new FileOutputStream(filePath2);

            char charFromFile;
            ArrayList<String> charsArray = new ArrayList<>();
            int index = 0;
            String floatNumStr = "";
            Double floatNum;
            int intNumber;
            String intStr;
            byte[] bytesArray;

            while (inputStream1.available() > 0)
            {
                charFromFile = (char) inputStream1.read();
                if (charFromFile == ' ')
                {
                    floatNumStr = "";
                    for (int i = 0; i < charsArray.size(); i++)
                    {
                        floatNumStr = floatNumStr + charsArray.get(i);
                    }
                    index = 0;
                    charsArray = new ArrayList<>();

                    floatNum = Double.valueOf(floatNumStr);
                    intNumber = (int) Math.round(floatNum);

                    intStr = String.valueOf(intNumber);
                    bytesArray = intStr.getBytes("UTF-8");
                    outputStream2.write(bytesArray);

                    outputStream2.write(' ');
                }
                else
                {
                    if ((charFromFile >= 45 && charFromFile <= 46) || (charFromFile >= 48 && charFromFile <= 57))
                        charsArray.add(index, String.valueOf(charFromFile));
                    index++;
                }
            }

            if (charsArray.size() > 0)
            {
                floatNumStr = "";
                for (int i = 0; i < charsArray.size(); i++)
                {
                    floatNumStr = floatNumStr + charsArray.get(i);
                }
                index = 0;
                charsArray = new ArrayList<>();

                floatNum = Double.valueOf(floatNumStr);
                //intNumber = floatNum.intValue();
                intNumber = (int) Math.round(floatNum);

                intStr = String.valueOf(intNumber);
                bytesArray = intStr.getBytes("UTF-8");
                outputStream2.write(bytesArray);

                outputStream2.write(' ');
            }

            inputStream1.close();
            outputStream2.close();
        }
        reader.close();
    }
}
