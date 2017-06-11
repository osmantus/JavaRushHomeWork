package com.javarush.test.level07.lesson06.task01;

import java.util.ArrayList;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> stringList = new ArrayList<String>();

        stringList.add("1-ая строка");
        stringList.add("2-ая строка");
        stringList.add("3-я строка");
        stringList.add("4-ая строка");
        stringList.add("5-ая строка");

        System.out.println(stringList.size());

        for (int i = 0; i < stringList.size(); i++)
            System.out.println(stringList.get(i));
    }
}
