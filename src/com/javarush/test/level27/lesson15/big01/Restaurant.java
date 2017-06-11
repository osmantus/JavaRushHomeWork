package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Alex on 19.12.2016.
 */
public class Restaurant
{
    private static final int ORDER_CREATING_INTERVAL = 100;

    private static final LinkedBlockingQueue<Order> QUEUE = new LinkedBlockingQueue<>();

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ENGLISH);

        Cook cook1 = new Cook("Maestro");
        Cook cook2 = new Cook("PestoMaker");
        Waitor waitor = new Waitor();

        cook1.setQueue(QUEUE);
        cook2.setQueue(QUEUE);
        cook1.addObserver(waitor);
        cook2.addObserver(waitor);

        Thread cookTask1 = new Thread(cook1);
        Thread cookTask2 = new Thread(cook2);

        cookTask1.start();
        cookTask2.start();

        /*StatisticEventManager.getInstance().register(cook1);
        StatisticEventManager.getInstance().register(cook2);*/

        List<Tablet> tabletsList = new ArrayList<>();

        for (int i = 0; i < 5; i++)
        {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(QUEUE);
            /*if (i % 2 == 0)
                tablet.addObserver(cook1);
            else
                tablet.addObserver(cook2);*/

            //tablet.addObserver(orderManager);
            tabletsList.add(tablet);
        }

        RandomOrderGeneratorTask task = new RandomOrderGeneratorTask(tabletsList, ORDER_CREATING_INTERVAL);
        Thread thread = new Thread(task);
        thread.start();

        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {}
        thread.interrupt();
        cookTask1.interrupt();
        cookTask2.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();

        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
