package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String monthName = reader.readLine();

        HashMap<String, Integer> monthsByNumber = new HashMap<String, Integer>();

        monthsByNumber.put("January", 1);
        monthsByNumber.put("February", 2);
        monthsByNumber.put("March", 3);
        monthsByNumber.put("April", 4);
        monthsByNumber.put("May", 5);
        monthsByNumber.put("June", 6);
        monthsByNumber.put("July", 7);
        monthsByNumber.put("August", 8);
        monthsByNumber.put("September", 9);
        monthsByNumber.put("October", 10);
        monthsByNumber.put("November", 11);
        monthsByNumber.put("December", 12);

        Integer monthNumber = 0;
        if (monthsByNumber.containsKey(monthName))
        {
            monthNumber = monthsByNumber.get(monthName);
            System.out.println(monthName + " is " + monthNumber + " month");
        }
    }

}
