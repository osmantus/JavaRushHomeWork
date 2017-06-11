package com.javarush.test.level25.lesson05.home01;

public class LoggingStateThread extends Thread
{
    private Thread checkedThread;

    public LoggingStateThread(Thread target)
    {
        //System.out.println(target.getState());
        checkedThread = target;
        setDaemon(true);
    }

    @Override
    public void run()
    {
        State curState = checkedThread.getState();
        System.out.println(curState);
        while (curState != State.TERMINATED)
        {
            if (curState != checkedThread.getState())
            {
                curState = checkedThread.getState();
                System.out.println(curState);
            }
        }
    }

}
