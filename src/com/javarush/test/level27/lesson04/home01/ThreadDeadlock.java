package com.javarush.test.level27.lesson04.home01;

public class ThreadDeadlock {
    static Object data;
    public synchronized static Object getData() {
       return data;
    }
}
