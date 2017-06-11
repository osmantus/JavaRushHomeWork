package com.javarush.test.level04.lesson06.task04;

/* Сравнить имена
Ввести с клавиатуры два имени, и если имена одинаковые вывести сообщение «Имена идентичны». Если имена разные, но их длины равны – вывести сообщение – «Длины имен равны».
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String name1 = buffer.readLine();
        String name2 = buffer.readLine();

        if (name1.compareTo(name2) == 0)
            System.out.println("Имена идентичны");
        else
        {
            if (name1.length() == name2.length())
                System.out.println("Длины имен равны");
        }
    }
}
