package com.javarush.test.level04.lesson04.task04;

/* Время года
Реализовать метод checkSeason. По номеру месяца, метод должен определить время года (зима, весна, лето, осень) и вывести на экран.
Пример для номера месяца 2:
зима
Пример для номера месяца 5:
весна
*/

public class Solution
{
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
    }

    public static void checkSeason(int month){
        if ((month >= 1 && month <= 2) || month == 12)
            System.out.println("зима");
        else if (month >= 3 && month <= 5)
            System.out.println("весна");
        else if (month >= 6 && month <= 8)
            System.out.println("лето");
        else
            System.out.println("осень");
    }
}