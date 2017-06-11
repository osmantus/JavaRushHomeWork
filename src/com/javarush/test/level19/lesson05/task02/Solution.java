package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-com.javarush.test.level19.lesson10.home10.user.resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        String filePath;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        filePath = reader.readLine();
        reader.close();

        File file = new File(filePath);
        String nextToken = null;

        int counter = 0;
        if (file.exists())
        {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
                nextToken = scanner.next().trim();
                nextToken = nextToken.replaceAll("\\W", "");

                if (nextToken.equals("world"))
                    counter++;
            }
            scanner.close();
        }
        System.out.println(counter);
    }
}
