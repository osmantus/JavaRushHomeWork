package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-com.javarush.test.level19.lesson10.home10.user.resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception {

        final char UTF8Flag = '\uFEFF';
        final char charSpace = '\u0020';

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        reader.close();

        Scanner scanner = new Scanner(new BufferedReader(new FileReader(filePath)));

        String fileLine = "";

        String strPart = null;
        String[] arrayList = null;
        int counter = 0;

        while (scanner.hasNextLine())
        {
            fileLine = scanner.nextLine();
            if (!fileLine.equals(""))
            {
                fileLine = fileLine.replace(UTF8Flag, charSpace).trim();
                counter = 0;
                arrayList = fileLine.split(" ");
                for (int i = 0; i < arrayList.length; i++)
                {
                    if (words.contains(arrayList[i]))
                        counter++;
                }
                if (counter == 2)
                    System.out.println(fileLine);
            }
        }

        scanner.close();
    }
}
