package com.javarush.test.level08.lesson11.home01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution
{
    public static class Cat
    {
        /*private String catName;
        public Cat(String catName)
        {
            this.catName = catName;
        }
        public String getCatName()
        {
            return catName;
        }
        void printCatName()
        {
            System.out.println(catName);
        }
        public String toString()
        {
            return getCatName();
        }*/
    }

    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();

        if (!cats.isEmpty())
        {
            ArrayList<Cat> arrayList = new ArrayList<Cat>();
            arrayList.addAll(cats);
            /*for (Cat item : cats)
            {
                arrayList.add(item);
            }*/

            Cat curCat;
            for (int i = 0; i < arrayList.size(); i++)
            {
                //if (arrayList.get(i).getCatName().equals("Котик1"))
                //{
                if (i == 0)
                {
                    curCat = arrayList.get(i);
                    if (curCat != null)
                    {
                        if (cats.contains(curCat))
                        {
                            cats.remove(curCat);
                        }
                    }
                }
                //}
            }

        }

        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        Set<Cat> catsSet = new HashSet<Cat>();

        for (int i = 0; i < 3; i++)
            //catsSet.add(new Cat("Котик" + i));
            catsSet.add(new Cat());

        if (!catsSet.isEmpty())
            return catsSet;
        else
            return null;
    }

    public static void printCats(Set<Cat> cats)
    {
        /*for (Cat item : cats)
            item.printCatName();*/

        for (Cat item : cats)
            System.out.println(item);
    }
}
