package com.javarush.test.level08.lesson11.home02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats()
    {
        HashSet<Cat> result = new HashSet<Cat>();

        for (int i = 0; i < 4; i++)
        {
            result.add(new Cat());
        }

        return result;
    }

    public static Set<Dog> createDogs()
    {
        HashSet<Dog> result = new HashSet<Dog>();

        for (int i = 0; i < 3; i++)
        {
            result.add(new Dog());
        }

        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs)
    {
        Set<Object> anyObjectsSet = new HashSet<Object>();

        for (Cat item : cats)
        {
            anyObjectsSet.add(item);
        }
        for (Dog item : dogs)
        {
            anyObjectsSet.add(item);
        }
        //anyObjectsSet.add(cats);
        //anyObjectsSet.add(dogs);

        if (!anyObjectsSet.isEmpty())
            return anyObjectsSet;
        else
            return null;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats)
    {
        ArrayList<Cat> catsArray = new ArrayList<Cat>();
        catsArray.addAll(cats);

        for (Cat item : catsArray)
        {
            if (pets.contains(item))
                pets.remove(item);
        }
    }

    public static void printPets(Set<Object> pets)
    {
        for (Object item : pets)
        {
            System.out.println(item);
        }
    }

    public static class Cat
    {

    }

    public static class Dog
    {

    }
}
