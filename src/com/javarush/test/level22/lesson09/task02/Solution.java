package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {

        StringBuilder result = new StringBuilder("");

        for (Map.Entry<String, String> eachEntry : params.entrySet())
        {
            if (eachEntry.getValue() != null)
            {
                if (!result.toString().equals(""))
                    result = result.append(" and ");
                result = result.append(eachEntry.getKey());
                result = result.append(" = '");
                result = result.append(eachEntry.getValue());
                result = result.append("'");
            }
        }

        return result;
    }
}
