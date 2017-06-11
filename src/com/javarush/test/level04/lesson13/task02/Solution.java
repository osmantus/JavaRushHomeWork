package com.javarush.test.level04.lesson13.task02;

import java.io.*;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int m = 0, n = 0;

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String inputTxt1 = buffer.readLine();
        String inputTxt2 = buffer.readLine();

        m = Integer.parseInt(inputTxt1);
        n = Integer.parseInt(inputTxt2);

        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                System.out.print("8");
            }
            System.out.println();
        }
    }
}
