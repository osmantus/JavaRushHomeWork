package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Alex on 05.06.2016.
 */
public class UkrainianHen extends Hen
{
    @Override
    public int getCountOfEggsPerMonth()
    {
        return 2000;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + UKRAINE + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
