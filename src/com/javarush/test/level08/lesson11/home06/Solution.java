package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human grandfather1 = new Human("Дедушка1", true, 61);
        Human grandfather2 = new Human("Дедушка2", true, 60);

        Human grandmother1 = new Human("Бабушка1", false, 59);
        Human grandmother2 = new Human("Бабушка2", false, 58);

        Human father = new Human("Отец", true, 38);
        Human mother = new Human("Мать", false, 35);

        Human son1 = new Human("Сын1", true, 12);
        Human son2 = new Human("Сын2", true, 9);
        Human daughter1 = new Human("Дочь", false, 5);

        father.addChild(son1);
        father.addChild(son2);
        father.addChild(daughter1);

        mother.addChild(son1);
        mother.addChild(son2);
        mother.addChild(daughter1);

        grandfather1.addChild(father);
        grandmother1.addChild(father);

        grandfather2.addChild(mother);
        grandmother2.addChild(mother);

        System.out.println(grandfather1);
        System.out.println(grandfather2);
        System.out.println(grandmother1);
        System.out.println(grandmother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(daughter1);
    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children;

        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public void addChild(Human child)
        {
            if (child != null)
            {
                if (this.children != null)
                {
                    this.children.add(child);
                }
                else
                {
                    this.children = new ArrayList<Human>();
                    this.children.add(child);
                }
            }
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.children != null)
            {
                int childCount = this.children.size();
                if (childCount > 0)
                {
                    text += ", дети: " + this.children.get(0).name;

                    for (int i = 1; i < childCount; i++)
                    {
                        Human child = this.children.get(i);
                        text += ", " + child.name;
                    }
                }
            }

            return text;
        }
    }

}
