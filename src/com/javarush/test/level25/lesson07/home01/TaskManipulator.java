package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator {

    private Thread thisThread;
    private String innerThreadName;

    @Override
    public void run()
    {
        try
        {
            while (!thisThread.isInterrupted())
            {
                System.out.println(innerThreadName);
                Thread.sleep(100);
            }
        }
        catch (InterruptedException e)
        {}
    }

    @Override
    public void start(String threadName)
    {
        innerThreadName = threadName;

        thisThread = new Thread(this);
        thisThread.start();
    }

    @Override
    public void stop()
    {
        thisThread.interrupt();
    }
}
