package com.javarush.test.level19.lesson08.task05;

/* Дублируем текст
Считайте с консоли имя файла
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна дублировать вывод всего текста в файл, имя которого вы считали
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Закройте поток файла

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();
    public static String filePath;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            filePath = reader.readLine();
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        PrintStream consoleStream = System.out;

        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        PrintStream stream = new PrintStream(fileOutputStream);
        System.setOut(stream);

        testString.printSomething();

        System.setOut(consoleStream);
        fileOutputStream.close();

        BufferedReader bf = new BufferedReader(new FileReader(filePath));
        while (bf.ready())
            System.out.println(bf.readLine());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

