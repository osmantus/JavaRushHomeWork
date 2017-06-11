package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-com.javarush.test.level19.lesson10.home10.user.resources
Не используйте System.exit();
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {

        String fileName = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            while (true)
            {
                fileName = reader.readLine();
                File file = new File(fileName);
                if (!file.exists())
                    throw new FileNotFoundException();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(fileName);
        }
        finally
        {
            if (reader != null)
               reader.close();
        }
    }
}
