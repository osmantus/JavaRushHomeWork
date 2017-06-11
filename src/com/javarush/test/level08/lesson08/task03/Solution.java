package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    static HashMap<String, String> myMap;
    //static int counterSameFirstName;
    //static int counterSameLastName;

    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> myMap = new HashMap<String, String>();

        myMap.put("Иванов1", "Иван");
        myMap.put("Иванов2", "Сергей");
        myMap.put("Петров", "Пётр");
        myMap.put("Сидоров1", "Иван");
        myMap.put("Сидоров2", "Василий");
        myMap.put("Непомнящий", "Фёдор");
        myMap.put("Белый", "Андрей");
        myMap.put("Пушкин", "Сергей");
        myMap.put("Иванов3", "Александр");
        myMap.put("Быков", "Александр");

        return myMap;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int counter = 0;
        for (String item : map.values())
        {
            if (item.equals(name))
                counter++;//counterSameFirstName++;//counter++;
        }
        return counter;//counterSameFirstName;//counter;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int counter = 0;
        for (String item : map.keySet())
        {
            if (item.equals(lastName))
                counter++;//counterSameLastName++;//counter++;
        }
        return counter;//counterSameLastName;//counter;
    }

    public static void main(String[] args)
    {
        HashMap<String, String> myMap = createMap();
        if (!myMap.isEmpty())
        {
            //counterSameFirstName = getCountTheSameFirstName(myMap, "Иван");
            //counterSameLastName = getCountTheSameLastName(myMap, "Пушкин");
            //getCountTheSameFirstName(myMap, "Иван");
            //getCountTheSameLastName(myMap, "Пушкин");
            System.out.println(getCountTheSameFirstName(myMap, "Иван"));
            System.out.println(getCountTheSameLastName(myMap, "Пушкин"));
        }
    }
}
