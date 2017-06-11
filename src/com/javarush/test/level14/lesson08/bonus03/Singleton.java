package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Alex on 09.06.2016.
 */
public class Singleton
{
    //static int objCounter = 0;
    static Singleton oneObj;
    private int anyProperty;

    public static Singleton getInstance()
    {
        if (oneObj == null)
        {
            oneObj = new Singleton(25);
            //objCounter++;
        }
        return oneObj;
    }

    private Singleton(int anyProperty)
    {
        this.anyProperty = anyProperty;
    }
}
