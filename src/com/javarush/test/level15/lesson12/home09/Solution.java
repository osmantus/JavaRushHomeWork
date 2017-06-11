package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            String urlString = reader.readLine();
            int shiftPos;

            if (urlString.contains("?"))
            {
                int pos = urlString.indexOf("?") + 1;
                String paramNameAndValue = "";
                String paramName = "";
                String paramValue = "";
                double paramValDbl = 0.0;

                String paramsSubStr = urlString.substring(pos);

                ArrayList<String> strArray = new ArrayList<String>();
                
                while (!paramsSubStr.equals(""))
                {
                    shiftPos = 0;
                    if (paramsSubStr.contains("&"))
                        pos = paramsSubStr.indexOf("&");
                    else
                        pos = paramsSubStr.length();

                    paramNameAndValue = paramsSubStr.substring(shiftPos, pos);
                    shiftPos = pos + 1; //следующее место в строке для чтения параметра URL
                    if (paramNameAndValue.contains("="))
                    {
                        pos = paramNameAndValue.indexOf("=");
                        paramName = paramNameAndValue.substring(0, pos);
                        if (paramName.equals("obj"))
                        {
                            pos = pos + 1;
                            paramValue = paramNameAndValue.substring(pos, paramNameAndValue.length());
                        }

                        strArray.add(paramName);
                    }
                    else
                    {
                        paramName = paramNameAndValue;
                        strArray.add(paramName);
                    }
                    if (shiftPos < paramsSubStr.length())
                        paramsSubStr = paramsSubStr.substring(shiftPos, paramsSubStr.length());
                    else
                        paramsSubStr = "";
                }

                for (String item : strArray)
                    System.out.print(item + " ");
                System.out.println();

                if (!paramValue.equals(""))
                {
                    try
                    {
                        paramValDbl = Double.valueOf(paramValue);
                        alert(paramValDbl);                        
                    }
                    catch (Exception e)
                    {
                        //e.printStackTrace();
                        alert(paramValue);
                    }
                }
            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
