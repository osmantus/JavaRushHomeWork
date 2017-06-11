package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader readerFromConsole = new BufferedReader(new InputStreamReader(System.in));
        String fileName = readerFromConsole.readLine();
        readerFromConsole.close();

        //Scanner scannedFile = new Scanner(new InputStreamReader(new FileInputStream(fileName)));
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        String str = null, revStr = null;
        LinkedList<String> originAndReverseList = new LinkedList<>();
        LinkedList<String> allWords = new LinkedList<>();

        String key = null;
        Pair pair = null;
        String[] keyAndValueArray = null;

        String line = null;
        while ((line = br.readLine()) != null)
        {
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++)
            {
                revStr = getReverseStr(words[i]);
                if (allWords.contains(revStr))
                {
                    key = revStr.concat(" ").concat(words[i]);
                    originAndReverseList.add(key);
                    keyAndValueArray = key.split(" ");

                    if (keyAndValueArray != null)
                    {
                        if (keyAndValueArray.length == 2)
                        {
                            pair = new Pair();
                            if (pair != null)
                            {
                                pair.first = keyAndValueArray[0];
                                pair.second = keyAndValueArray[1];
                                result.add(pair);
                            }
                        }
                    }
                    LinkedList<String> revStrArray = new LinkedList<>();
                    revStrArray.add(revStr);
                    allWords.removeAll(revStrArray);
                }
                else
                    allWords.add(words[i]);
            }
        }
        br.close();

        if (result != null)
        {
            for (Pair eachPair : result)
                System.out.println(eachPair.toString());
        }

        /*while (scannedFile.hasNext())
        {
            str = scannedFile.next();
            revStr = getReverseStr(str);

            key = str.concat(" ").concat(revStr);
            if (!originAndReverseList.contains(key))
                originAndReverseList.add(key);
        }
        scannedFile.close();*/
        
        /*if (originAndReverseList != null)
        {
            for (String eachEntry : originAndReverseList)
            {
                keyAndValueArray = eachEntry.split(" ");
                if (keyAndValueArray != null)
                {
                    if (keyAndValueArray.length == 2)
                    {
                        if (originAndReverseList.contains(keyAndValueArray[1].concat(" ").concat(keyAndValueArray[0])))
                        {
                            pair = new Pair();
                            if (pair != null)
                            {
                                pair.first = keyAndValueArray[0];
                                pair.second = keyAndValueArray[1];
                                if (!result.contains(pair))
                                    result.add(pair);
                            }
                        }
                    }
                }
            }

            if (result != null)
            {
                for (Pair eachPair : result)
                    System.out.println(eachPair.toString());
            }
        }*/
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }

    }

    public static String getReverseStr(String originalStr)
    {
        StringBuilder sb = new StringBuilder(originalStr);
        return sb.reverse().toString();
    }
}
