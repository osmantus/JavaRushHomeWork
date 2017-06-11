package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader((System.in)));

        String inputTxt1 = buffer.readLine();
        String inputTxt2 = buffer.readLine();
        String inputTxt3 = buffer.readLine();

        int a = Integer.parseInt(inputTxt1);
        int b = Integer.parseInt(inputTxt2);
        int c = Integer.parseInt(inputTxt3);

        if (a < b && b < c)
            System.out.println(b);   // b
        else if (a < c && c < b)
            System.out.println(c);   // c
        else if (b < a && a < c)
            System.out.println(a);   // a
        else if (b < c && c < a)
            System.out.println(c);   // c
        else if (c < a && a < b)
            System.out.println(a);   // a
        else if (c < b && b < a)
            System.out.println(b);   // b
        else if (a == b && b < c)
            System.out.println(b);
        else if (a == c && c < b)
            System.out.println(c);
        else if (b == c && c < a)
            System.out.println(c);
        else
            System.out.println(a);
    }
}
