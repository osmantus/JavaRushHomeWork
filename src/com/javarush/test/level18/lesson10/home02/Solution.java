package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-com.javarush.test.level19.lesson10.home10.user.resources
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception {

        int allSymbolsCounter = 0;
        int spaceSymbolCounter = 0;

        int symbolCode = -1;

        FileInputStream inputStream = new FileInputStream(args[0]);
        if (inputStream != null)
        {
            allSymbolsCounter = inputStream.available();
            if (allSymbolsCounter > 0)
            {
                while (inputStream.available() > 0)
                {
                    symbolCode = inputStream.read();
                    if (symbolCode == ' ')
                        spaceSymbolCounter++;
                }
                System.out.format("%.2f%n", ((double) spaceSymbolCounter / (double) allSymbolsCounter) * 100.00);
            }
        }
        inputStream.close();
    }
}
