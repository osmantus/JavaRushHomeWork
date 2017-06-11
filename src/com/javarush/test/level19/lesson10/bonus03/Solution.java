package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        if (args[0].equals(""))
            return;

        String keyTag = "<".concat(args[0]);
        String closeTag = "</".concat(args[0]).concat(">");

        /*keyTag = "(";
        closeTag = ")";*/

        int keyTagLen = keyTag.length();
        int closeTagLen = closeTag.length();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        reader.close();

        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String fileLine = null;
        int keyTagPos = -2;
        int closeTagPos = -2;

        String keyTagPosStr = "";

        String withinTagsStr = null;
        String strBuffer = null;

        StringBuilder sb = new StringBuilder();
        String strToRead = null;
        int tagStartPos = 0;
        int strIndex = 0;

        LinkedList<String> list = new LinkedList<>();
        //ArrayList<String> printedList = new ArrayList<>();

        SortedMap<Integer, String> tagStartedFromMap = new TreeMap<Integer, String>();

        while (br.ready())
        {
            fileLine = br.readLine();
            sb.append(fileLine);
        }
        br.close();

        if (sb.length() > 0)
        {
            strBuffer = sb.substring(0);
            strToRead = strBuffer;
            strIndex = 0;

            while (strToRead.contains(keyTag) || strToRead.contains(closeTag))
            {
                if (strToRead.contains(keyTag) && strToRead.contains(closeTag))
                {
                    keyTagPos = strBuffer.indexOf(keyTag, strIndex);
                    closeTagPos = strBuffer.indexOf(closeTag, strIndex);

                    if (keyTagPos < closeTagPos)
                    {
                        keyTagPosStr = String.valueOf(keyTagPos);
                        list.push(keyTagPosStr);

                        strIndex = keyTagPos + keyTagLen;
                    } else
                    {
                        if (!list.isEmpty())
                        {
                            tagStartPos = Integer.valueOf(list.pop());
                            withinTagsStr = strBuffer.substring(tagStartPos, closeTagPos + closeTagLen);
                            //printedList.add(0, withinTagsStr);
                            tagStartedFromMap.put(tagStartPos, withinTagsStr);
                        }
                        strIndex = closeTagPos + closeTagLen;
                    }

                    strToRead = strBuffer.substring(strIndex, strBuffer.length());
                }
                else if (strToRead.contains(keyTag))
                {
                    keyTagPos = strBuffer.indexOf(keyTag, strIndex);
                    keyTagPosStr = String.valueOf(keyTagPos);
                    list.push(keyTagPosStr);

                    strIndex = keyTagPos + keyTagLen;

                    strToRead = strBuffer.substring(strIndex, strBuffer.length());
                }
                else if (strToRead.contains(closeTag))
                {
                    closeTagPos = strBuffer.indexOf(closeTag, strIndex);
                    if (!list.isEmpty())
                    {
                        tagStartPos = Integer.valueOf(list.pop());
                        withinTagsStr = strBuffer.substring(tagStartPos, closeTagPos + closeTagLen);
                        //printedList.add(0, withinTagsStr);
                        tagStartedFromMap.put(tagStartPos, withinTagsStr);
                    }
                    strIndex = closeTagPos + closeTagLen;

                    strToRead = strBuffer.substring(strIndex, strBuffer.length());
                }
            }

            /*for (String eachStr : printedList)
            {
                System.out.println(eachStr);
            }*/

            for (Map.Entry<Integer, String> entry : tagStartedFromMap.entrySet())
            {
                System.out.println(entry.getValue());
            }
        }

    }

}
