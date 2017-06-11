package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {

        String result = null;

        if (string != null)
        {
            if (string.contains("\t"))
            {
                String subStr = string;
                int index = 0;
                while (subStr.indexOf((int)'\t') >= 0)
                {
                    index = index + 1;
                    if (index == 2)
                    {
                        if (subStr.contains("\t"))
                            result = subStr.substring(0, subStr.indexOf('\t'));
                        else
                            result = subStr;
                        break;
                    }
                    subStr = subStr.substring(subStr.indexOf((int)'\t')+1);
                }
            } else
                throw new TooShortStringException();
        }
        else
            throw new TooShortStringException();

        if (result == null)
            throw new TooShortStringException();
        return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        try
        {
            System.out.println(getPartOfString("123\t123"));                //Exception
        }
        catch (TooShortStringException e)
        {
            System.out.println(e.getMessage());
            String[] classNameStrings = e.getClass().getName().split("\\$");
            if (classNameStrings != null)
                System.out.println(classNameStrings[classNameStrings.length-1]);
            System.out.println(Thread.currentThread().getName());
        }
        System.out.println(getPartOfString(null));                      //Exception
    }
}
