package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());

        if (a != 0 || b != 0)
        {
            int maxValue = 1;
            int NOD = 1;

            if (Math.abs(a) <= Math.abs(b))
                maxValue = a;
            else
                maxValue = b;

            maxValue = Math.abs(maxValue);

            if (maxValue >= 2)
            {
                for (int i = 2; i <= maxValue; i++)
                {
                    if (a % i == 0 && b % i == 0)
                    {
                        NOD = i;
                        //break;
                    }
                }
                System.out.println(NOD);
            }
            else
                System.out.println(1);
        }
    }
}
