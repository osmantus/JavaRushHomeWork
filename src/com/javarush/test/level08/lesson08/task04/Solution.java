package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));

        map.put("Stallone2", new Date("JUNE 1 1981"));
        map.put("Stallone3", new Date("JANUARY 1 1982"));
        map.put("Stallone4", new Date("JUNE 1 1983"));
        map.put("Stallone5", new Date("JUNE 1 1984"));
        map.put("Stallone6", new Date("SEPTEMBER 1 1985"));
        map.put("Stallone7", new Date("JUNE 1 1986"));
        map.put("Stallone8", new Date("JUNE 1 1987"));
        map.put("Stallone9", new Date("MARCH 1 1988"));
        map.put("Stallone10", new Date("JUNE 1 1989"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //int curYear;
        int curMonth;
        //int curDay;
        //Date curDT;

        //HashMap<String, Date> cloneMap = (HashMap<String, Date>) map.clone();

        HashMap<String, Date> modMap = new HashMap<String, Date>();

        for (Map.Entry<String, Date>item : map.entrySet())
        {
            //curDT = new Date(item.getDate());
            //curYear = item.getYear();
            curMonth = item.getValue().getMonth();
            //curDay = item.getDay();
            if (curMonth < 5 || curMonth > 7)
            {
                //map.remove(item);
                modMap.put(item.getKey(), item.getValue());
            }
        }

        map.clear();
        map.putAll(modMap);
    }

    public static void main(String[] args)
    {
        HashMap<String, Date> myMap = createMap();
        if (!myMap.isEmpty())
        {
            removeAllSummerPeople(myMap);
            for (Map.Entry<String, Date>item : myMap.entrySet())
            {
                System.out.println(item.getKey() + " - " + item.getValue());
            }
        }
    }

}
