package com.javarush.test.level03.lesson04.task05;

/* Сумма 10 чисел
Вывести на экран сумму чисел от 1 до 10 построчно (должно быть 10 строк):
1
1+2=3
1+2+3=6
1+2+3+4=10
...
Пример вывода:
1
3
6
10
...
*/

public class Solution
{
    public static void main(String[] args)
    {
        int sum = 0;

        sum = sum + 1;
        System.out.println(sum);

        sum = sum + 2;
        System.out.println(sum);

        sum = sum + 3;
        System.out.println(sum);

        sum = sum + 4;
        System.out.println(sum);

        sum = sum + 5;
        System.out.println(sum);

        sum = sum + 6;
        System.out.println(sum);

        sum = sum + 7;
        System.out.println(sum);

        sum = sum + 8;
        System.out.println(sum);

        sum = sum + 9;
        System.out.println(sum);

        sum = sum + 10;
        System.out.println(sum);
    }
}