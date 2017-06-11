package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Alex on 19.12.2016.
 */
public class Tablet // extends Observable// implements Runnable
{
    private final int number;
    private final static Logger logger = Logger.getLogger(Tablet.class.getName());
    //private AdvertisementManager advManager;

    private LinkedBlockingQueue<Order> queue;

    public Tablet(int number)
    {
        this.number = number;
    }

    public void createOrder()
    {
        try
        {
            Order order = new Order(this);
            createOrderUtil(order);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    @Override
    public String toString()
    {
        return "Tablet{" + "number=" + number + '}';
    }

    public void createTestOrder()
    {
        try
        {
            TestOrder testOrder = new TestOrder(this);
            createOrderUtil(testOrder);
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    private void createOrderUtil(Order order)
    {
        if (!order.isEmpty())
        {
            ConsoleHelper.writeMessage(order.toString());
            /*setChanged();
            notifyObservers(order);*/

            //advManager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            try
            {
                //advManager.processVideos();
                new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
            }
            catch (NoVideoAvailableException e)
            {
                logger.log(Level.INFO, "No video is available for the order " + order);
            }

            queue.add(order);
        }
    }

    public void setQueue(LinkedBlockingQueue<Order> queue)
    {
        this.queue = queue;
    }
}
