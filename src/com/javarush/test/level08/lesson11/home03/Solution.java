package com.javarush.test.level08.lesson11.home03;

import java.util.HashMap;
import java.util.Map;

/* Люди с одинаковыми именами и/или фамилиями
1. Создать словарь Map (<String, String>) и добавить туда 10 человек в виде «Фамилия»-«Имя».
2. Пусть среди этих 10 человек есть люди с одинаковыми именами.
3. Пусть среди этих 10 человек есть люди с одинаковыми фамилиями.
4. Вывести содержимое Map на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList()
    {
        Map<String, String> peopleMap = new HashMap<String, String>();

        peopleMap.put("Фамилия1", "Имя1");
        peopleMap.put("Фамилия2", "Имя2");
        peopleMap.put("Фамилия3", "Имя3");
        peopleMap.put("Фамилия4", "Имя4");
        peopleMap.put("Фамилия5", "Имя5");
        peopleMap.put("Фамилия6", "Имя1");
        peopleMap.put("Фамилия7", "Имя7");
        peopleMap.put("Фамилия3", "Имя8");
        peopleMap.put("Фамилия9", "Имя9");
        peopleMap.put("Фамилия3", "Имя4");

        return peopleMap;
    }

    public static void printPeopleList(Map<String, String> map)
    {
        for (Map.Entry<String, String> s : map.entrySet())
        {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }

}
