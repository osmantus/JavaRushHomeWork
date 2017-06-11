package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        Human grandFather1 = new Human("Дедушка1", true, 60, null, null);
        Human grandFather2 = new Human("Дедушка2", true, 62, null, null);

        Human grandMother1 = new Human("Бабушка1", false, 55, null, null);
        Human grandMother2 = new Human("Бабушка2", false, 58, null, null);

        Human father = new Human("Папа", true, 35, grandFather1, grandMother1);
        Human mother = new Human("Мама", false, 33, grandFather2, grandMother2);

        Human son1 = new Human("Сын1", true, 12, father, mother);
        Human son2 = new Human("Сын2", true, 8, father, mother);
        Human daughter = new Human("Дочь", false, 3, father, mother);

        System.out.println(grandFather1);
        System.out.println(grandFather2);

        System.out.println(grandMother1);
        System.out.println(grandMother2);

        System.out.println(father);
        System.out.println(mother);

        System.out.println(son1);
        System.out.println(son2);
        System.out.println(daughter);
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
