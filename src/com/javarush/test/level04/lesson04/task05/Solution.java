package com.javarush.test.level04.lesson04.task05;

/* Положительное и отрицательное число
Ввести с клавиатуры число. Если число положительное, то увеличить его в два раза. Если число отрицательное, то прибавить единицу.
Вывести результат на экран.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String inputTxt = buffer.readLine();
        int inputInt = Integer.parseInt(inputTxt);

        if (inputInt > 0)
            inputInt = inputInt * 2;
        else
            inputInt = inputInt + 1;

        System.out.println(inputInt);

    }

}