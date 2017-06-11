package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Alex on 05.06.2016.
 */
public class BelarusianHen extends Hen
{
    @Override
    public int getCountOfEggsPerMonth()
    {
        return 1000;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + BELARUS + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
