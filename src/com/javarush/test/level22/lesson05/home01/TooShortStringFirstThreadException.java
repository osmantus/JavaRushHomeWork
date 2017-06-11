package com.javarush.test.level22.lesson05.home01;

public class TooShortStringFirstThreadException extends RuntimeException {
    public TooShortStringFirstThreadException(String s)
    {
        super(s);
    }

    public TooShortStringFirstThreadException(Throwable cause)
    {
        super(cause);
    }
}
