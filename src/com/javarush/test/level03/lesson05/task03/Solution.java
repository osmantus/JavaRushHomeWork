package com.javarush.test.level03.lesson05.task03;

/* Конвертер времени
Добавьте метод public static int convertToSeconds(int hour) который будет конвертировать часы в секунды.
Вызовите его дважды в методе main с любыми параметрами. Результаты выведите на экран, каждый раз с новой строки.
*/

public class Solution
{

    static int convertToSeconds(int hour)
    {
        return hour * 3600;
    }

    public static void main(String[] args) {
        int res1 = convertToSeconds(3);
        int res2 = convertToSeconds(12);

        System.out.println(res1);
        System.out.println(res2);
    }
}