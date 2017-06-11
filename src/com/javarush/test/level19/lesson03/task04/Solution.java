package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            if (scanner != null)
            {
                String fileStr = scanner.nextLine();

                String[] dataArray = fileStr.split(" ");

                String lastname = dataArray[0];
                String firstname = dataArray[1];
                String middlename = dataArray[2];

                String day = dataArray[3];
                String month = dataArray[4];
                String year = dataArray[5];
                Calendar date = Calendar.getInstance();
                date.set(Integer.valueOf(year), Integer.valueOf(month)-1, Integer.valueOf(day), 0, 0, 0);

                Person person = new Person(firstname, middlename, lastname, date.getTime());

                return person;
            }
            else
                return null;
        }

        @Override
        public void close() throws IOException
        {
            if (scanner != null)
                scanner.close();
        }
    }

    public static void main(String args[]) throws Exception
    {
        File file = new File("D:\\Work\\Java\\L19Task4\\list2.txt");
        if (file.exists())
        {
            Scanner scanner = new Scanner(file);
            PersonScannerAdapter adapter = new PersonScannerAdapter(scanner);

            Person person = adapter.read();
            System.out.println(person.toString());
            adapter.close();
        }
    }
}
