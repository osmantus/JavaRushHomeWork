package com.javarush.test.level17.lesson10.home09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();

            BufferedReader inStream1 = new BufferedReader(new FileReader(fileName1));
            BufferedReader inStream2 = new BufferedReader(new FileReader(fileName2));

            String fileString = "";

            try
            {
                while ((fileString = inStream1.readLine()) != null)
                {
                    allLines.add(fileString);
                }
                inStream1.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            try
            {
                while ((fileString = inStream2.readLine()) != null)
                {
                    forRemoveLines.add(fileString);
                }
                inStream2.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            try
            {
                Solution solution = new Solution();
                solution.joinData();
            }
            catch (CorruptedDataException e)
            {
                e.printStackTrace();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void joinData() throws CorruptedDataException {

        List<String> forRemoveLinesCopy = new ArrayList<>();
        forRemoveLinesCopy.addAll(forRemoveLines);

        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else
        {
            if (forRemoveLinesCopy.retainAll(allLines))
            {
                if (forRemoveLines.size() != forRemoveLinesCopy.size())
                {
                    allLines.clear();
                    throw new CorruptedDataException();
                }
            }
        }
    }
}
