package com.javarush.test.level25.lesson09.task03;

/* Живем своим умом
В классе Solution реализуйте интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений начиная с самого вложенного.
Пример исключения: new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e)
    {
        t.interrupt();
        //e.printStackTrace();
        /*while (e != null)
        {
            //System.out.println(e.toString());
            //e = e.getCause();
        }*/
        System.out.println(recursiveFunc(e));
    }

    private String recursiveFunc(Throwable e)
    {
        Throwable lowerLevelError = e.getCause();
        if (lowerLevelError != null)
            return recursiveFunc(e.getCause()) + "\n" + e.toString();
        else
            return e.toString();
    }

    public static void main(String[] args)
    {
        Solution sol = new Solution();

        try
        {
            throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        }
        catch (Exception e)
        {
            sol.uncaughtException(Thread.currentThread(), e);
        }
    }
}
