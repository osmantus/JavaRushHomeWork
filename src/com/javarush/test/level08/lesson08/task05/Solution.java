package com.javarush.test.level08.lesson08.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        /*
        HashMap<String, String> testMap = new HashMap<String, String>(map);
        */
        /*for (Map.Entry<String, String> item : map.entrySet())
        {
            //map.putAll(testMap);
            testMap.remove(item);
            removeItemFromMapByValue(testMap, item.getValue());
            //testMap.clear();
            testMap.put(item.getKey(), item.getValue());
        }*/

        /*
        String key;
        String value;
        //Iterator<Map.Entry<String, String>> prevIteratorValue;

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        //prevIteratorValue = iterator;

        while (iterator.hasNext())
        {
            Map.Entry<String, String> item = iterator.next();
            key = item.getKey();
            value = item.getValue();
            testMap.remove(key);

            //map.remove(key);

            removeItemFromMapByValue(testMap, value);
            //removeItemFromMapByValue(map, value);
            testMap.put(key, value);
            //map.put(key, value);
        }
        map.clear();
        map.putAll(testMap);
        */

        ArrayList<String> arrayList = new ArrayList<String>();
        for (String item : map.values())
        {
            arrayList.add(item);
        }

        for (int i = 0; i < arrayList.size(); i++)
        {
            String value1 = arrayList.get(i);
            //int counter = 0;
            for (int j = i+1; j < arrayList.size(); j++)
            {
                String value2 = arrayList.get(j);
                if (value1.equals(value2))
                {
                    //counter++;
                    //if (counter >= 2)
                    removeItemFromMapByValue(map, value2);
                }
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args)
    {
        HashMap<String, String> myMap = createMap();
        if (!myMap.isEmpty())
        {
            removeTheFirstNameDuplicates(myMap);
            for (Map.Entry<String, String>item : myMap.entrySet())
            {
                System.out.println(item.getKey() + " - " + item.getValue());
            }
        }
    }

}
