package com.javarush.test.level03.lesson08.task02;

/* Зарплата через 5 лет
Ввести с клавиатуры отдельно Имя, число1, число2. Вывести надпись:
«Имя» получает «число1» через «число2» лет.
Пример: Коля получает 3000 через 5 лет.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String name = buffer.readLine();
        String number1Txt = buffer.readLine();
        String number2Txt = buffer.readLine();

        int number1 = Integer.parseInt(number1Txt);
        int number2 = Integer.parseInt(number2Txt);

        System.out.println(name + " получает " + number1 + " через " + number2 + " лет.");
    }
}