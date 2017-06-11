package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Alex on 05.06.2016.
 */
public class RussianHen extends Hen
{
    @Override
    public int getCountOfEggsPerMonth()
    {
        return 800;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " Моя страна - " + RUSSIA + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
