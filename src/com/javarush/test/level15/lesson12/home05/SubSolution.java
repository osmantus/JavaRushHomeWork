package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Alex on 14.06.2016.
 */
public class SubSolution extends Solution
{
    SubSolution(boolean bool)
    {
        super(bool);
    }

    SubSolution(float floatNumber)
    {
        super(floatNumber);
    }

    SubSolution(byte byteVar)
    {
        super(byteVar);
    }

    private SubSolution()
    {
        super(0);
    }

    private SubSolution(long longNumber)
    {
        super(longNumber);
    }

    private SubSolution(char charVar)
    {
        super(charVar);
    }

    public SubSolution(int intNumber)
    {
        super(intNumber);
    }

    public SubSolution(short shortNumber)
    {
        super(shortNumber);
    }

    public SubSolution(double doubleNumber)
    {
        super(doubleNumber);
    }

    protected SubSolution(String anyString)
    {
        super(anyString);
    }

    protected SubSolution(Integer anyString)
    {
        super(anyString);
    }

    protected SubSolution(Float anyString)
    {
        super(anyString);
    }
}
