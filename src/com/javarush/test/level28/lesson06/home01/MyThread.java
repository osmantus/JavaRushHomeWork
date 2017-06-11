package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ua053202 on 21.12.2016.
 */
public class MyThread extends Thread
{
    /*private static int MIN_PRIORITY = 2;
    private static int MAX_PRIORITY = 10;*/
    private static AtomicInteger i = new AtomicInteger(0);

    private void setLocalPriority(ThreadGroup curGroup)
    {
        if (curGroup != null)
        {
            int groupPriority = curGroup.getMaxPriority();

            if (i.get() < MIN_PRIORITY)
            {
                i.set(MIN_PRIORITY);
                this.setPriority(MIN_PRIORITY);
            } else if (MIN_PRIORITY + i.get() <= MAX_PRIORITY)
            {
                if (MIN_PRIORITY + i.get() < groupPriority)
                {
                    this.setPriority(MIN_PRIORITY + i.get() % groupPriority);
                    i.incrementAndGet();
                } else
                {
                    this.setPriority(groupPriority);
                    i.incrementAndGet();
                }
            } else
            {
                i.set(MIN_PRIORITY);
                this.setPriority(MIN_PRIORITY);
            }
        }
        else
        {
            if (i.get() < MIN_PRIORITY)
            {
                i.set(MIN_PRIORITY);
                this.setPriority(MIN_PRIORITY);
            }
            else if (MIN_PRIORITY + i.get() <= MAX_PRIORITY)
            {
                this.setPriority(MIN_PRIORITY + i.get() % MAX_PRIORITY);
                i.incrementAndGet();
            }
            else
            {
                i.set(MIN_PRIORITY);
                this.setPriority(MIN_PRIORITY);
            }
        }
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        setLocalPriority(group);
    }

    public MyThread()
    {
        setLocalPriority(null);
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        setLocalPriority(group);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        setLocalPriority(group);
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        setLocalPriority(group);
    }

    public MyThread(Runnable target)
    {
        super(target);
        setLocalPriority(null);
    }

    public MyThread(String name)
    {
        super(name);
        setLocalPriority(null);
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        setLocalPriority(null);
    }
}
