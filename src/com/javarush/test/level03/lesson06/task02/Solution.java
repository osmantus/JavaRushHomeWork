package com.javarush.test.level03.lesson06.task02;

/* Таблица умножения
Выведи на экран таблицу умножения 10 на 10 в следующем виде:
1 2 3 …
2 4 6 …
3 6 9 …
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        final int tabSize = 10;
        for(int i = 1; i <= tabSize; i++)
        {
            for(int j = 1; j <= tabSize; j++)
            {
                System.out.print(i*j);
                if (j < 10)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}