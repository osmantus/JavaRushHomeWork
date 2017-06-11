package com.javarush.test.level04.lesson06.task05;

/* 18+
Ввести с клавиатуры имя и возраст. Если возраст меньше 18 вывести надпись «Подрасти еще».
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String name = buffer.readLine();
        String ageTxt = buffer.readLine();

        int age = Integer.parseInt(ageTxt);
        if (age < 18)
            System.out.println("Подрасти еще");
    }
}
