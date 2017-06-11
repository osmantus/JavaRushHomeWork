package com.javarush.test.level16.lesson07.task01;

/* Часы
1. Разберись, что делает программа.
2. Реализуйте логику метода printTikTak:
2.1. Через первые полсекунды должна выводиться в консоль фраза: Tik.
2.2. Через вторые полсекунды должна выводиться в консоль фраза: Tak.
*/

import java.util.Date;

public class Solution {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock();
        Thread.sleep(2000);
        isStopped = true;
        System.out.println("Clock has to be stopped");
        Thread.sleep(1000);
        System.out.println("Double-check");
    }

    public static class Clock extends Thread {

        /*private Date startDate;
        private boolean isTikPrinted;
        private boolean isTakPrinted;*/

        public Clock() {
            setPriority(MAX_PRIORITY);
            //startDate = new Date();
            start();
        }

        public void run() {
            try {
                while (!isStopped) {
                    printTikTak();
                }
            } catch (InterruptedException e) {
            }
        }

        private void printTikTak() throws InterruptedException {
            /*Date curDate = new Date();

            if (curDate.getTime() - startDate.getTime() > 2000 && !isTikPrinted)
            {
                System.out.println("Tik");
                isTikPrinted = true;
            }
            else if (curDate.getTime() - startDate.getTime() > 4000 && !isTakPrinted)
            {
                System.out.println("Tak");
                isTakPrinted = true;
            }*/

            sleep(500);
            System.out.println("Tik");
            sleep(500);
            System.out.println("Tak");
        }
    }
}
