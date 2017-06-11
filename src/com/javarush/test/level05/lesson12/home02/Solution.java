package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man man1 = new Man("Alexander", 20, "Address1");
        Man man2 = new Man("Oleg", 30, "Address2");

        Woman woman1 = new Woman("Natali", 22, "Address3");
        Woman woman2 = new Woman("Tanya", 28, "Address4");

        System.out.println(man1.getName() + " " + man1.getAge() + " " + man1.getAddress());
        System.out.println(man2.getName() + " " + man2.getAge() + " " + man2.getAddress());
        System.out.println(woman1.getName() + " " + woman1.getAge() + " " + woman1.getAddress());
        System.out.println(woman2.getName() + " " + woman2.getAge() + " " + woman2.getAddress());
    }

    public static class Man
    {
        private String name;
        private int age;
        private String address;

        Man(String name)
        {
            this.name = name;
        }
        Man(String name, int age)
        {
            this.name = name;
            this.age = age;
        }
        Man(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        String getName() {return name;};
        int getAge() {return age;};
        String getAddress() {return address;};
    }
    public static class Woman
    {
        private String name;
        private int age;
        private String address;

        Woman(String name)
        {
            this.name = name;
        }
        Woman(String name, int age)
        {
            this.name = name;
            this.age = age;
        }
        Woman(String name, int age, String address)
        {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        String getName() {return name;};
        int getAge() {return age;};
        String getAddress() {return address;};
    }
}
