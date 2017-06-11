package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-com.javarush.test.level19.lesson10.home10.user.resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Solution {
    public static void main(String[] args) throws Exception
    {
        int symbolCode = -1;
        int engLettersCounter = 0;

        FileInputStream inputStream = new FileInputStream(args[0]);
        if (inputStream != null)
        {
            while (inputStream.available() > 0)
            {
                symbolCode = inputStream.read();
                if (symbolCode >= 65 && symbolCode <= 90 || symbolCode >= 97 && symbolCode <= 122)
                    engLettersCounter++;
            }
        }
        System.out.println(engLettersCounter);
        inputStream.close();
    }
}
