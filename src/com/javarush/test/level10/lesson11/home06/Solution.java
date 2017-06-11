package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

import java.util.Date;

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String name;
        int age;
        Date birthday;
        int sex;
        String countryOrigin;
        String occupation;

        public Human(String name, Date birthday)
        {
            this.name = name;
            this.birthday = birthday;
        }
        public Human(String name, Date birthday, int sex)
        {
            this.name = name;
            this.birthday = birthday;
            this.sex = sex;
        }
        public Human(String name, int age, Date birthday, int sex)
        {
            this.name = name;
            this.age = age;
            this.birthday = birthday;
            this.sex = sex;
        }
        public Human(String name, int age, Date birthday, int sex, String countryOrigin)
        {
            this.name = name;
            this.age = age;
            this.birthday = birthday;
            this.sex = sex;
            this.countryOrigin = countryOrigin;
        }
        public Human(String name, int age, Date birthday, int sex, String countryOrigin, String occupation)
        {
            this.name = name;
            this.age = age;
            this.birthday = birthday;
            this.sex = sex;
            this.countryOrigin = countryOrigin;
            this.occupation = occupation;
        }
        public Human(String name, String countryOrigin, String occupation)
        {
            this.name = name;
            this.countryOrigin = countryOrigin;
            this.occupation = occupation;
        }
        public Human(String name, Date birthday, String countryOrigin)
        {
            this.name = name;
            this.birthday = birthday;
            this.countryOrigin = countryOrigin;
        }
        public Human(String name, Date birthday, String countryOrigin, String occupation)
        {
            this.name = name;
            this.birthday = birthday;
            this.countryOrigin = countryOrigin;
            this.occupation = occupation;
        }
        public Human(String name, int sex)
        {
            this.name = name;
            this.sex = sex;
        }
        public Human(int sex)
        {
            this.sex = sex;
        }
    }
}
