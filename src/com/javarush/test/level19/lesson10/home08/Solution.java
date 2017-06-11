package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-com.javarush.test.level19.lesson10.home10.user.resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        reader.close();

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String fileLine = null;
        char[] charsArray = null;
        char[] reversedArray = null;

        final char UTF8Flag = '\uFEFF';
        final char charSpace = '\u0020';

        while (br.ready())
        {
            fileLine = br.readLine();
            fileLine = fileLine.replace(UTF8Flag, charSpace).trim();
            charsArray = fileLine.toCharArray();

            for (int i = charsArray.length-1; i >= 0; i--)
            {
                System.out.print(charsArray[i]);
            }
            System.out.println();
        }

        br.close();
    }
}
