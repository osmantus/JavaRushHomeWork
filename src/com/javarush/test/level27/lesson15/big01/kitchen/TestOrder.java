package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Alex on 08.01.2017.
 */
public class TestOrder extends Order
{
    public TestOrder(Tablet tablet) throws IOException
    {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException
    {
        //super.initDishes();
        /*List<Dish> shuffledDishes = new ArrayList<>();
        Collections.addAll(shuffledDishes, Dish.values());
        Collections.shuffle(shuffledDishes);

        int dishesCount = Dish.values().length;
        int dishesNewRandomCount = 1 + (int)Math.floor(((double) dishesCount) * Math.random());

        //int dishesNewRandomCount = ThreadLocalRandom.current().nextInt(1, dishesCount);

        if (dishesNewRandomCount == dishesCount + 1)
            dishesNewRandomCount--;
        dishes = shuffledDishes.subList(0, dishesNewRandomCount);*/

        /*dishes = new ArrayList<>();

        int dishesNewRandomCount = (int) (Math.random() * Dish.values().length);
        for (int i = 0; i < dishesNewRandomCount; i++)
        {
            dishes.add(Dish.values()[i]);
        }*/

        /*this.dishes = new ArrayList<>();
        int numRandom = ThreadLocalRandom.current().nextInt(1,Dish.values().length);
        if (numRandom==0){numRandom=1;}
        Dish[] dishMas = Dish.values();
        for(int i = 0; i < numRandom; i++){
            int random = (int)(Math.random() * (Dish.values().length));
            dishes.add(dishMas[random]);
        }*/

        dishes = new ArrayList<>();
        int dishesCount = 3;// (int) (Math.random() * Dish.values().length);
        for (int i = 0; i < dishesCount; i++) {
            dishes.add(Dish.values()[(int) (Math.random() * Dish.values().length)]);
        }

    }
}
