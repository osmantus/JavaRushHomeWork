package com.javarush.test.level03.lesson08.task04;

/* Спонсор - это звучит гордо
Ввести с клавиатуры два имени и вывести надпись:
name1 проспонсировал name2, и она стала известной певицей.
Пример:
Коля проспонсировал Лену, и она стала известной певицей.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        //System.out.print("Введите, пожалуйста, имя спонсора: ");
        String name1 = buffer.readLine();
        //System.out.print("Введите, пожалуйста, имя того, кого спонсировали: ");
        String name2 = buffer.readLine();
        System.out.println(name1 + " проспонсировал " + name2 + ", и она стала известной певицей.");
    }
}