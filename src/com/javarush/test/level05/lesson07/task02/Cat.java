package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    private String name = null;
    private Double weight; // = 5.0;
    private int age; //= 2;
    private String color = "Gray";
    private String address = null;

    public void initialize(String name)
    {
        this.name = name;
        if (weight == null)
            weight = 5.0;
        if (age == 0)
            age = 2;
        if (color == "")
            color = "Gray";
    }
    public void initialize(String name, Double weight, int age)
    {
        this.name = name;
        this.weight = weight;
        this.age = age;
        if (color == "")
            color = "Gray";
    }
    public void initialize(String name, int age)
    {
        this.name = name;
        this.age = age;
        if (weight == null)
            weight = 5.0;
        if (color == "")
            color = "Gray";
    }
    public void initialize(Double weight, String color)
    {
        this.weight = weight;
        this.color = color;
        if (age == 0)
            age = 2;
    }
    public void initialize(Double weight, String color, String address)
    {
        this.weight = weight;
        this.color = color;
        this.address = address;
        if (age == 0)
            age = 2;
    }
}
