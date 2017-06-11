package com.javarush.test.level06.lesson11.home02;

import java.util.ArrayList;

/* Статические коты
1. В классе Cat добавь public статическую переменную cats (ArrayList<Cat>).
2. Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот. Создать 10 объектов Cat.
3. Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.
*/

public class Cat {
    public Cat() {
    }

    static public ArrayList<Cat> cats;

    public static void main(String[] args) {

        cats = new ArrayList<Cat>();

        for (int i = 0; i < 10; i++)
            cats.add(new Cat());

        printCats();
    }

    public static void printCats() {
        for (Cat cat : cats)
            System.out.println(cat);
    }
}
