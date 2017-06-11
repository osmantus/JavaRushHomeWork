package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by Alex on 19.12.2016.
 */
public enum Dish
{
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int duration)
    {
        this.duration = duration;
    }

    public int getDuration()
    {
        return duration;
    }

    public static String allDishesToString()
    {
        String result = "";
        for (Dish eachDish : values())
        {
            if (result.equals(""))
                result = eachDish.toString();
            else
                result = result + ", " + eachDish.toString();
        }
        return result;
    }
}
