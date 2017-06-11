package com.javarush.test.level30.lesson06.home01;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by ua053202 on 19.01.2017.
 */
public class BinaryRepresentationTask extends RecursiveTask<String>
{
    private final int originalValueToCompute;

    public BinaryRepresentationTask(int i)
    {
        originalValueToCompute = i;
    }

    @Override
    protected String compute()
    {
        int a = originalValueToCompute % 2;
        int b = originalValueToCompute / 2;
        String result = String.valueOf(a);
        if (b > 0)
        {
            BinaryRepresentationTask binary = new BinaryRepresentationTask(b);
            binary.fork();
            return binary.join() + result;
        }
        return result;
    }
}
