package com.javarush.test.level08.lesson11.home09;

import java.util.*;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        isDateOdd("MAY 1 2013");
        /*if (isDateOdd("MAY 1 2013"))
            System.out.println("Нечётное число дней.");
        else
            System.out.println("Чётное число дней.");*/
    }

    public static boolean isDateOdd(String date)
    {
        /*Date curDateAsDate = new Date(date);

        Date firstDayOfYear = new Date(date);
        firstDayOfYear.setHours(0);
        firstDayOfYear.setMinutes(0);
        firstDayOfYear.setSeconds(0);

        firstDayOfYear.setDate(1);
        firstDayOfYear.setMonth(0);

        long msPassed = curDateAsDate.getTime() - firstDayOfYear.getTime();

        int daysPassed = (int) (msPassed / (24 * 60 * 60 * 1000));

        if (daysPassed % 2 == 0)
            return false;
        else
            return true;*/

        //if (date != "")
        //{
        int pos = 0, prevPos = 0;

        pos = date.indexOf(" ");
        String month = new String(date.substring(0, pos));

        prevPos = pos;
        pos = date.indexOf(" ", pos+1);
        String day = new String(date.substring(prevPos+1, pos));

        String year = new String(date.substring(pos+1));

        HashMap<String, Integer> monthsMap = new HashMap<String, Integer>();

        monthsMap.put("JANUARY", 31);

        if (isLeapYear(Integer.parseInt(year)))
            monthsMap.put("FEBRUARY", 29);
        else
            monthsMap.put("FEBRUARY", 28);

        monthsMap.put("MARCH", 31);
        monthsMap.put("APRIL", 30);
        monthsMap.put("MAY", 31);
        monthsMap.put("JUNE", 30);
        monthsMap.put("JULY", 31);
        monthsMap.put("AUGUST", 31);
        monthsMap.put("SEPTEMBER", 30);
        monthsMap.put("OCTOBER", 31);
        monthsMap.put("NOVEMBER", 30);
        monthsMap.put("DECEMBER", 31);

        //////
        SortedMap<Integer, String> monthsSortedMap = new TreeMap<Integer, String>();

        monthsSortedMap.put(new Integer(1), "JANUARY");
        monthsSortedMap.put(new Integer(2), "FEBRUARY");
        monthsSortedMap.put(new Integer(3), "MARCH");
        monthsSortedMap.put(new Integer(4), "APRIL");
        monthsSortedMap.put(new Integer(5), "MAY");
        monthsSortedMap.put(new Integer(6), "JUNE");
        monthsSortedMap.put(new Integer(7), "JULY");
        monthsSortedMap.put(new Integer(8), "AUGUST");
        monthsSortedMap.put(new Integer(9), "SEPTEMBER");
        monthsSortedMap.put(new Integer(10), "OCTOBER");
        monthsSortedMap.put(new Integer(11), "NOVEMBER");
        monthsSortedMap.put(new Integer(12), "DECEMBER");

        int daysPassed = 0;
        String monthName = "";

        for (Map.Entry<Integer, String> item : monthsSortedMap.entrySet())
        {
            monthName = item.getValue();
            if (!monthName.equals(month))
            {
                if (monthsMap.containsKey(monthName))
                {
                    if (daysPassed == 0)
                        daysPassed = monthsMap.get(monthName);  //item.getValue();
                    else
                        daysPassed = daysPassed + monthsMap.get(monthName); //item.getValue();
                }
            }
            else
            {
                daysPassed = daysPassed + Integer.parseInt(day);
                break;
            }
        }

        /*
        switch (month)
        {
            case "JANUARY":
                month = "01";
                break;
            case "FEBRUARY":
                month = "02";
                break;
            case "MARCH":
                month = "03";
                break;
            case "APRIL":
                month = "04";
                break;
            case "MAY":
                month = "05";
                break;
            case "JUNE":
                month = "06";
                break;
            case "JULY":
                month = "07";
                break;
            case "AUGUST":
                month = "08";
                break;
            case "SEPTEMBER":
                month = "09";
                break;
            case "OCTOBER":
                month = "10";
                break;
            case "NOVEMBER":
                month = "11";
                break;
            case "DECEMBER":
                month = "12";
                break;
        }*/

        /*if (day.length() == 1)
            day = "0".concat(day);
        */

        /*
        Date dateAsDate = new Date(new String(day + "." + month + "." + year));

        Date firstDayOfYear = new Date(date);
        firstDayOfYear.setHours(0);
        firstDayOfYear.setMinutes(0);
        firstDayOfYear.setSeconds(0);

        firstDayOfYear.setDate(1);
        firstDayOfYear.setMonth(0);

        long msPassed = dateAsDate.getTime() - firstDayOfYear.getTime();

        int daysPassed = (int) (msPassed / (24 * 60 * 60 * 1000));
        */

        //int daysPassed;

        if (daysPassed % 2 == 0)
            return false;
        else
            return true;
        //}
    }

    public static boolean isLeapYear(int year)
    {
        // високосный ли год?

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            return true;
        else
            return false;
    }
}
