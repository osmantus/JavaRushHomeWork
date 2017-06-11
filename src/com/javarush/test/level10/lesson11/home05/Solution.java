package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
д 0
…
я 9
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++)
        {
            alphabet.add(abcArray[i]);
        }

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        Map<String, Integer> lettersMap = new TreeMap<String, Integer>();
        String mapKey = "";
        Integer numOfLetters = 0;
        char[] newCharArray;

        for (String item : list)
        {
            newCharArray = item.toCharArray();
            for (int i = 0; i < newCharArray.length; i++)
            {
                if (alphabet.contains(newCharArray[i]))
                {
                    mapKey = String.valueOf(newCharArray[i]);
                    if (lettersMap.containsKey(mapKey))
                    {
                        numOfLetters = lettersMap.get(mapKey);
                        numOfLetters++;
                        lettersMap.put(mapKey, numOfLetters);
                    }
                    else
                        lettersMap.put(mapKey, 1);
                }
            }
        }

        /*for (Map.Entry<String, Integer> numOfLettersItem: lettersMap.entrySet())
            System.out.println(numOfLettersItem.getKey() + " " + numOfLettersItem.getValue());*/

        for (int i = 0; i < abcArray.length; i++)
        {
            mapKey = String.valueOf(abcArray[i]);
            if (lettersMap.containsKey(mapKey))
                System.out.println(mapKey + " " + lettersMap.get(mapKey));
            else
                System.out.println(mapKey + " 0");
        }
    }

}
