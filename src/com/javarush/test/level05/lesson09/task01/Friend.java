package com.javarush.test.level05.lesson09.task01;

/* Создать класс Friend
Создать класс Friend (друг) с тремя конструкторами:
- Имя
- Имя, возраст
- Имя, возраст, пол
*/

public class Friend
{
    private String name;
    private int age;
    private Boolean sex;

    public Friend()
    {
        this.name = "";
        this.age = 2;
        this.sex = true;
    }
    public Friend(String name, int age, Boolean sex)
    {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public Friend(Friend friend)
    {
        this.name = friend.name;
        this.age = friend.age;
        this.sex = friend.sex;
    }
}