package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-com.javarush.test.level19.lesson10.home10.user.resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int byteFromFile = 0;
        int symbolCounter = 0;

        FileInputStream inputStream = new FileInputStream(reader.readLine());
        while (inputStream.available() > 0)
        {
            byteFromFile = inputStream.read();
            if (byteFromFile == 44)
                symbolCounter++;
        }
        System.out.println(symbolCounter);
        inputStream.close();
        reader.close();
    }
}
