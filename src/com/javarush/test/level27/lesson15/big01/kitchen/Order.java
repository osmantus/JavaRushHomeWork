package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Alex on 19.12.2016.
 */
public class Order
{
    private Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException
    {
        //this.dishes = ConsoleHelper.getAllDishesForOrder();
        initDishes();
        this.tablet = tablet;
    }

    @Override
    public String toString()
    {
        if (dishes == null || dishes.isEmpty())
        {
            return "";
        }
        else
        {
            return "Your order: " + dishes + " of " + tablet;
        }
    }

    public int getTotalCookingTime()
    {
        int result = 0;
        for (Dish eachDish : dishes)
            result += eachDish.getDuration();
        return result;
    }

    public boolean isEmpty()
    {
        return dishes.isEmpty();
    }

    public List<Dish> getDishes()
    {
        return dishes;
    }

    protected void initDishes() throws IOException
    {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public Tablet getOrderTablet()
    {
        return tablet;
    }
}
