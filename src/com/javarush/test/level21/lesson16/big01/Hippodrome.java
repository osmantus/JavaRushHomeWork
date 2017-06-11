package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Alex on 30.10.2016.
 */
public class Hippodrome
{
    public static Hippodrome game = null;

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();

        Horse horse1 = new Horse("Horse1", 3, 0);
        Horse horse2 = new Horse("Horse2", 3, 0);
        Horse horse3 = new Horse("Horse3", 3, 0);

        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);

        game.run();

        game.printWinner();
    }

    public static ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run() throws InterruptedException
    {
        for (int i = 0; i < 100; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move()
    {
        for (Horse eachHorse : horses)
        {
            eachHorse.move();
        }
    }

    public void print()
    {
        for (Horse eachHorse : horses)
        {
            eachHorse.print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner()
    {
        double maxDistance = 0;
        Horse winner = null;
        for (Horse eachHorse : horses)
        {
            if (maxDistance < eachHorse.getDistance())
            {
                maxDistance = eachHorse.getDistance();
                winner = eachHorse;
            }
        }
        return winner;
    }

    public void printWinner()
    {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
