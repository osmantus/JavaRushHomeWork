package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-com.javarush.test.level19.lesson10.home10.user.resources
*/

public class Solution {
    public static volatile Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception {

        String fileName = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String readLine = "";

        ReadThread readThread;

        do
        {
            readLine = reader.readLine();
            if (!readLine.equals("exit"))
            {
                fileName = readLine;
                readThread = new ReadThread(fileName);
                readThread.start();
                readThread.join();
            }
        } while (!readLine.equals("exit"));

        reader.close();
    }

    public static class ReadThread extends Thread {

        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run()
        {
            try
            {
                FileInputStream inStream = new FileInputStream(fileName);

                Integer fileSymbol = 0;
                Integer counter;
                HashMap<Integer, Integer> charsCountMap = new HashMap<>();

                while (inStream.available() > 0)
                {
                    fileSymbol = inStream.read();
                    if (charsCountMap.containsKey(fileSymbol))
                    {
                        counter = charsCountMap.get(fileSymbol) + 1;
                        charsCountMap.put(fileSymbol, counter);
                    }
                    else
                    {
                        charsCountMap.put(fileSymbol, 1);
                    }
                }

                Integer maxCounter = 0;

                for (Map.Entry<Integer, Integer> eachItem : charsCountMap.entrySet())
                {
                    if (eachItem.getValue() > maxCounter)
                    {
                        maxCounter = eachItem.getValue();
                        fileSymbol = eachItem.getKey();
                    }
                }

                synchronized (resultMap)
                {
                    resultMap.put(fileName, fileSymbol);
                }

                inStream.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
