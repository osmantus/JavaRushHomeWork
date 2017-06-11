package com.javarush.test.level25.lesson09.task02;

import java.util.TimerTask;

/* Вооружаемся до зубов!
Создайте свой UncaughtExceptionHandler в виде локального класса внутри конструктора.
UncaughtExceptionHandler должен маскать звездочками имя трэда.
"Thread-0" должно быть заменено на "********"
"Thread-4321" должно быть заменено на "***********"
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;

        //this.handler = null;    //init handler here

        class LocalUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler
        {
            @Override
            public void uncaughtException(Thread t, Throwable e)
            {
                String threadOrigName = t.getName();
                int len = t.getName().length();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < len; i++)
                {
                    sb.append("*");
                }
                String newThreadName = sb.toString();

                System.out.println(e.getMessage().replace(threadOrigName, newThreadName));
            }
        }

        this.handler = new LocalUncaughtExceptionHandler();
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) throws InterruptedException
    {
        TimerTask timer = new TimerTask()
        {
            @Override
            public void run()
            {
                int a = 10 / 0;
            }
        };
        Solution sol = new Solution(timer);
        //sol.run();

        TimerTask timer2 = new TimerTask()
        {
            @Override
            public void run()
            {
                int a = 10 / 0;
            }
        };
        TimerTask timer3 = new TimerTask()
        {
            @Override
            public void run()
            {
                //int a = 10 / 0;
                throw new Error();
            }
        };
        Thread thread = new Thread(null, timer2, "Thread-1");
        Thread thread2 = new Thread(null, timer3, "Thread-1234");

        thread.setUncaughtExceptionHandler(sol.handler);
        thread2.setUncaughtExceptionHandler(sol.handler);

        thread.start();
        thread.join();
        thread2.start();

        sol.run();
    }
}