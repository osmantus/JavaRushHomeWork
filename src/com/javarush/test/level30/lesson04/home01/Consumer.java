package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by ua053202 on 29.12.2016.
 */
public class Consumer implements Runnable
{
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        try
        {
            ShareItem item = null;

            Thread.sleep(500);
            while (true)
            {
                item = queue.take();
                if (item != null)
                    System.out.println("Processing " + item);
            }
        }
        catch (InterruptedException e)
        {}
    }
}
