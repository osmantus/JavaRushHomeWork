package com.javarush.test.level26.lesson10.home01;

/**
 * Created by Alex on 04.12.2016.
 */

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable
{
    protected BlockingQueue queue;

    public Consumer(BlockingQueue queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        try {
            int i = 0;
            while (true)
            {
                if (!queue.isEmpty())
                {
                    System.out.println(queue.take());
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}