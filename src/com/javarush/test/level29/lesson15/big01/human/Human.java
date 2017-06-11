package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;

    private List<Human> children = new ArrayList<>();

    public class Size
    {
        public int height;
        public int weight;
    }

    protected Size size;

    public static final BloodGroup FIRST = BloodGroup.first();
    public static final BloodGroup SECOND = BloodGroup.second();
    public static final BloodGroup THIRD = BloodGroup.third();
    public static final BloodGroup FOURTH = BloodGroup.fourth();
    private BloodGroup bloodGroup;

    public void setBloodGroup(BloodGroup group) {
        bloodGroup = group;
    }
    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public Human(String name, int age)
    {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void live() {
    }

    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human child)
    {
        children.add(child);
    }

    public void removeChild(Human child) throws IndexOutOfBoundsException
    {
        if (!children.isEmpty())
            children.remove(child);
    }

    public String getPosition()
    {
        return "Человек";
    }

    public void printData()
    {
        System.out.println(getPosition() + ": " + name);
    }
}
