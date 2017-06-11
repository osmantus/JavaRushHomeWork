package com.javarush.test.level22.lesson05.home01;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ThisUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public synchronized void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else
            if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
                System.out.println(getFormattedStringForSecondThread(t, e, string));
            } else {
                System.out.println(getFormattedStringForOtherThread(t, e, string));
            }
    }

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {

        String result = null;

        PrintStream backupConsoleStream = System.out;

        ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
        PrintStream outPrintStream = new PrintStream(outByteStream);
        System.setOut(outPrintStream);

        System.out.printf(string, e.getClass().getSimpleName(), e.getCause(), t.getName());
        result = outByteStream.toString();

        System.setOut(backupConsoleStream);

        return result;
    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {

        String result = null;

        PrintStream backupConsoleStream = System.out;

        ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
        PrintStream outPrintStream = new PrintStream(outByteStream);
        System.setOut(outPrintStream);

        System.out.printf(string, e.getCause(), e.getClass().getSimpleName(), t.getName());
        result = outByteStream.toString();

        System.setOut(backupConsoleStream);

        return result;
    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {

        String result = null;

        PrintStream backupConsoleStream = System.out;

        ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
        PrintStream outPrintStream = new PrintStream(outByteStream);
        System.setOut(outPrintStream);

        System.out.printf(string, t.getName(), e.getClass().getSimpleName(), e.getCause());
        result = outByteStream.toString();

        System.setOut(backupConsoleStream);

        return result;
    }
}

