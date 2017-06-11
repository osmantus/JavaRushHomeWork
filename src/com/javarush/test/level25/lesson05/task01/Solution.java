package com.javarush.test.level25.lesson05.task01;

/* Switch для нитей
Обработайте список нитей в зависимости от состояния:
1. Если нить еще не запущена, то запустите ее.
2. Если нить в ожидании, то прервите ее.
3. Если нить работает, то проверить маркер isInterrupted.
4. Если нить прекратила работу, то выведите в консоль ее приоритет.
Используйте switch.
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод

        for (Thread eachTread : threads)
        {
            switch(eachTread.getState())
            {
                case NEW:
                    eachTread.start();
                    break;
                case WAITING: case TIMED_WAITING: case BLOCKED:
                    eachTread.interrupt();
                    break;
                case RUNNABLE:
                    if (eachTread.isInterrupted())
                    break;
                case TERMINATED:
                    System.out.println(eachTread.getPriority());
                    break;
            }
        }
    }
}
