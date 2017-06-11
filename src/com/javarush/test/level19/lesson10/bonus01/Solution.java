package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1Path = reader.readLine();
        String file2Path = reader.readLine();
        reader.close();

        ArrayList<String> file1Lines = new ArrayList<>();
        ArrayList<String> file2Lines = new ArrayList<>();

        String fileLine = null;

        BufferedReader br1 = new BufferedReader(new FileReader(file1Path));
        while (br1.ready())
        {
            fileLine = br1.readLine();
            file1Lines.add(fileLine);
        }
        br1.close();

        BufferedReader br2 = new BufferedReader(new FileReader(file2Path));
        while (br2.ready())
        {
            fileLine = br2.readLine();
            file2Lines.add(fileLine);
        }
        br2.close();

        String file1Str = null, file2Str = null;

        if (file1Lines.size() == 0 || file2Lines.size() == 0)
            return;

        for (int i = 0; i < file1Lines.size(); i++)
        {
            file1Str = file1Lines.get(i);
            if (file2Lines.size() >= 1)
            {
                file2Str = file2Lines.get(0);

                if (file1Str.equals(file2Str))
                {
                    LineItem lineItem = new LineItem(Type.SAME, file1Str);
                    lines.add(lineItem);
                    file2Lines.remove(0);
                } else
                {
                    if (file2Lines.size() >= 2)
                    {
                        file2Str = file2Lines.get(1);
                        if (file1Str.equals(file2Str))
                        {
                            LineItem lineItem = new LineItem(Type.ADDED, file2Lines.get(0));
                            lines.add(lineItem);
                            file2Lines.remove(0);
                            i--;
                        } else
                        {
                            LineItem lineItem = new LineItem(Type.REMOVED, file1Str);
                            lines.add(lineItem);
                        }
                    } else
                    {
                        LineItem lineItem = new LineItem(Type.REMOVED, file1Str);
                        lines.add(lineItem);
                    }
                }
            }
            else
            {
                LineItem lineItem = new LineItem(Type.REMOVED, file1Str);
                lines.add(lineItem);
            }
        }


        if (file2Lines.size() > 0)
        {
            for (int i = 0; i < file2Lines.size(); i++)
            {
                file2Str = file2Lines.get(i);
                LineItem lineItem = new LineItem(Type.ADDED, file2Str);
                lines.add(lineItem);
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
