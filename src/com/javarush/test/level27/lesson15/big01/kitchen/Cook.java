package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Alex on 31.12.2016.
 */
public class Cook extends Observable implements Runnable
{
    private String name;
    private boolean busy;
    private volatile boolean isTaken = false;

    private LinkedBlockingQueue<Order> queue;

    public Cook(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }

    public boolean isBusy()
    {
        return busy;
    }

    public void startCookingOrder(Order order)
    {
        try
        {
            //busy = true;
            Tablet tablet = order.getOrderTablet();

            int totalCookingTimeSleepMs = order.getTotalCookingTime() * 10;
            ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %dmin", order, order.getTotalCookingTime()));

            CookedOrderEventDataRow event = new CookedOrderEventDataRow(tablet.toString(), name, order.getTotalCookingTime() * 60, order.getDishes());
            StatisticEventManager.getInstance().register(event);

            Thread.sleep(totalCookingTimeSleepMs);
            //busy = false;
        }
        catch (Exception e)
        {
            isTaken = true;
        }

        setChanged();
        notifyObservers(order);
    }

    public void setQueue(LinkedBlockingQueue<Order> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        while (!isTaken)
        {
            try
            {
                Thread.sleep(100);
                if (!queue.isEmpty())
                {
                    if (queue.size() > 0)
                    {
                        Order order = queue.poll();
                        if (order != null)
                        {
                            startCookingOrder(order);
                        }
                    }
                }
            }
            catch (InterruptedException e)
            {
                isTaken = false;
            }
        }
    }
}
