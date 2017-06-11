package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-com.javarush.test.level19.lesson10.home10.user.resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception {

        if (args[0].equals(""))
            return;

        String filePath = args[0];
        Scanner scanner = new Scanner(new FileReader(filePath));

        String fileLine = "";

        String strPart = null;
        int day = 0;
        int month = 0;
        int year = 0;
        Calendar date = null;

        while (true)
        {
            if (scanner.hasNextInt())
            {
                day = scanner.nextInt();
                if (scanner.hasNextInt())
                {
                    month = scanner.nextInt();
                    if (scanner.hasNextInt())
                    {
                        year = scanner.nextInt();
                        date = Calendar.getInstance();
                        date.set(year, month - 1, day);

                        Person person = new Person(fileLine, date.getTime());
                        PEOPLE.add(person);

                        fileLine = "";
                        date = null;
                    }
                }
            } else if (scanner.hasNext())
            {
                strPart = scanner.next();
                if (!fileLine.equals(""))
                    fileLine = fileLine + " " + strPart;
                else
                    fileLine = strPart;
            }
            else
                break;
        }

        scanner.close();
    }

}
