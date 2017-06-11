package com.javarush.test.level27.lesson15.big01;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Alex on 09.01.2017.
 */
public class RandomOrderGeneratorTask implements Runnable
{
    private List<Tablet> tabletsList;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval)
    {
        this.tabletsList = tablets;
        this.interval = interval;
    }

    @Override
    public void run()
    {
        if (!tabletsList.isEmpty())
        {
            while (!Thread.currentThread().isInterrupted())
            {
                try
                {
                    int tabletCount = tabletsList.size();
                    int tabletId = (int) ((double) tabletCount * Math.random());
                    //int tabletId = ThreadLocalRandom.current().nextInt(0, tabletCount-1);

                    Tablet tablet = tabletsList.get(tabletId);
                    tablet.createTestOrder();
                    Thread.sleep(interval);
                }
                catch (InterruptedException e)
                {
                    return;
                }
            }
        }
    }
}
