package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        console.close();

        Scanner fileIn = new Scanner(new FileInputStream(fileName));
        ArrayList<String> words = new ArrayList<>();

        while (fileIn.hasNext()) {
            words.add(fileIn.next());
        }
        fileIn.close();

        StringBuilder result = getLine(words.toArray(new String[0]));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < words.length * words.length; i++) {
            ArrayList<String> array = new ArrayList<>(Arrays.asList(words));
            res.delete(0, res.length());

            char curFirstLetter = 0;
            char curLastLetter = 0;
            char resFirstLetter = 0;
            char resLastLetter = 0;
            int curArraySize = 0;
            boolean firstLapse = true;

            while (array.size() != 0) {
                if (array.size() == curArraySize) break;

                Collections.shuffle(array);

                curArraySize = array.size();
                Iterator<String> iterator = array.iterator();
                while (iterator.hasNext()) {
                    String word = iterator.next();
                    curFirstLetter = Character.toLowerCase(word.charAt(0));
                    curLastLetter = Character.toLowerCase(word.charAt(word.length() - 1));
                    if (res.length() > 0) {
                        resFirstLetter = Character.toLowerCase(res.charAt(0));
                        resLastLetter = Character.toLowerCase(res.charAt(res.length() - 1));
                    }

                    if (curLastLetter == resFirstLetter) {
                        res.insert(0, " ");
                        res.insert(0, word);
                        iterator.remove();
                    } else if (firstLapse || curFirstLetter == resLastLetter) {
                        if (!firstLapse) res.append(" ");
                        res.append(word);
                        iterator.remove();
                        firstLapse = false;
                    }
                }
            }

            if (array.size() == 0) break;
        }
        return res;
    }
}
