package com.javarush.test.level26.lesson10.home02;

/**
 * Created by Alex on 04.12.2016.
 */

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable
{
    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map)
    {
        this.map = map;
    }

    @Override
    public void run()
    {
        try
        {
            int i = 0;
            while (true)
            {
                map.put(String.valueOf(i++), "Some text for " + i);
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
