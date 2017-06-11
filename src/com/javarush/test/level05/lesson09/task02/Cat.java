package com.javarush.test.level05.lesson09.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
- вес, цвет, адрес ( чужой домашний кот)
Задача конструктора – сделать объект валидным. Например, если вес не известен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String name;
    private Double weight;
    private int age;
    private String color;
    private String address;

    public Cat(String name)
    {
        this.name = name;
        this.weight = 5.0;
        this.age = 2;
        this.color = "Grey";
        this.address = null;
    }
    public Cat(String name, Double weight)
    {
        this.name = name;
        this.weight = weight;
        this.age = 2;
        this.color = "Grey";
        this.address = null;
    }
    public Cat(String name, Double weight, int age)
    {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "Grey";
        this.address = null;
    }
    public Cat(String name, Double weight, int age, String color)
    {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = color;
        this.address = null;
    }
    public Cat(String name, Double weight, int age, String color, String address)
    {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = color;
        this.address = address;
    }
}
