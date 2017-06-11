package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            String inputTxt = reader.readLine();
            char[] letters = inputTxt.toCharArray();

            ArrayList<String> arrayVowelChars = new ArrayList<String>();
            ArrayList<String> arrayNotVowelChars = new ArrayList<String>();

            for (int i = 0; i < letters.length; i++)
            {
                String strChar = new String(String.valueOf(letters[i]));
                if (!strChar.equals(" "))
                {
                    if (isVowel(letters[i]))
                    {
                        arrayVowelChars.add(strChar);
                    } else
                    {
                        arrayNotVowelChars.add(strChar);
                    }
                }
            }

            for (String item : arrayVowelChars)
                System.out.print(item + " ");
            System.out.println();
            for (String item : arrayNotVowelChars)
                System.out.print(item + " ");
        }
        catch (Exception e)
        {
            throw e;
        }
    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c)
    {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   //ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
