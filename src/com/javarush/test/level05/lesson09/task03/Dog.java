package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    private String name;
    private int age;
    private String color;

    public Dog(String name)
    {
        this.name = name;
    }
    public Dog(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    public Dog(String name, int age, String color)
    {
        this.name = name;
        this.age = age;
        this.color = color;
    }
}
