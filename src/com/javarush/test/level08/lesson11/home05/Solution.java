package com.javarush.test.level08.lesson11.home05;

//import com.sun.org.apache.xpath.internal.operations.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        char curSymbol;
        char prevSymbol = ' ';
        String upperSymb;

        String result = "";

        for (int i = 0; i < s.length(); i++)
        {
            curSymbol = s.charAt(i);

            if (prevSymbol == ' ' || prevSymbol == ',' || prevSymbol == '.' || prevSymbol == '-' || prevSymbol == ';' || prevSymbol == ':')
            {
                upperSymb = s.substring(i, i+1).toUpperCase();
                //result = result.concat(result.substring(0, i));
                result = result.concat(upperSymb);
            }
            /*else if (curSymbol != ' ' && curSymbol != ',' && curSymbol != '.' && curSymbol != '-' && curSymbol != ';' && curSymbol != ':')
            {
                upperSymb = s.substring(i, i+1).toUpperCase();
                result = result.concat(upperSymb);
                //s = s.replace(curSymbol, upperSymb);
            }*/
            else
                result = result.concat(s.substring(i, i+1));
            prevSymbol = curSymbol;
        }

        System.out.println(result);
    }
}
