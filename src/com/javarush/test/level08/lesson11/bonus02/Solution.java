package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        HashMap<String, String> addresses = new HashMap<String, String>();
        String city;
        String family;
        while (true)
        {
            city = reader.readLine();
            if (city.isEmpty()) break;
            family = reader.readLine();
            if (family.isEmpty()) break;

            addresses.put(city, family);
        }

        System.out.println();
        //read home number
        city = reader.readLine();

        System.out.println();

        if (addresses.containsKey(city))
        {
            String familySecondName = addresses.get(city);
            System.out.println(familySecondName);
        }
    }
}
