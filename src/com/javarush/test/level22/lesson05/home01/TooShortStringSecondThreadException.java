package com.javarush.test.level22.lesson05.home01;

public class TooShortStringSecondThreadException extends RuntimeException {
    public TooShortStringSecondThreadException(Throwable cause)
    {
        super(cause);
    }

    public TooShortStringSecondThreadException(String message)
    {
        super(message);
    }
}
