package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception {

        PrintStream consoleStream = System.out;

        ByteArrayOutputStream bytesOutputStream = new ByteArrayOutputStream();
        OutputStreamAdapter stream = new OutputStreamAdapter(bytesOutputStream);
        System.setOut(stream);

        testString.printSomething();

        System.setOut(consoleStream);

        System.out.println(bytesOutputStream.toString("UTF-8"));
        stream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }

    public static class OutputStreamAdapter extends PrintStream
    {
        static final String advString = "JavaRush - курсы Java онлайн";
        static private int strCounter;

        private ByteArrayOutputStream bytesOutputStream;

        public OutputStreamAdapter(OutputStream out)
        {
            super((ByteArrayOutputStream) out);
            bytesOutputStream = (ByteArrayOutputStream) out;
        }

        @Override
        public void println(String x)
        {
            super.println(x);
            strCounter++;
            if (strCounter > 0 && strCounter % 2 == 0)
                super.println(advString);
        }

        @Override
        public void close()
        {
            super.close();
            if (bytesOutputStream != null)
                try
                {
                    bytesOutputStream.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
        }
    }
}
