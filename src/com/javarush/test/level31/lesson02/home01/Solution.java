package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
    public static void main(String[] args) {

        String path, resultFileAbsolutePath;

        if (args.length < 2 || args.length > 2)
            return;

        path = args[0];
        resultFileAbsolutePath = args[1];

        File folder = new File(path);

        File fileListing = new File(resultFileAbsolutePath);

        if (folder.isDirectory() && fileListing.exists())
        {
            ArrayList<File> fileLessThan50Chars = new ArrayList<>();
            for (File file : getAllFilesInDir(folder))
            {
                if (file.length() > 50)
                {
                    file.delete();
                }
                else
                {
                    //String fileName = file.getName();
                    fileLessThan50Chars.add(file);
                }
            }

            Comparator<File> comp = new Comparator<File>()
            {
                @Override
                public int compare(File o1, File o2)
                {
                    return o1.getName().compareTo(o2.getName());
                }
            };
            Collections.sort(fileLessThan50Chars, comp);

            delEmptySubDirs(folder);

            File fileNewName = new File(fileListing.getParentFile() + File.separator + "allFilesContent.txt");
            fileListing.renameTo(fileNewName);

            if (fileNewName.exists())
            {
                try(FileOutputStream output = new FileOutputStream(fileNewName))
                {
                    for (File file : fileLessThan50Chars)
                    {
                        int fileSize = 0;
                        byte[] buffer = null;
                        try (FileInputStream inputStream = new FileInputStream(file))
                        {
                            fileSize = inputStream.available();
                            if (fileSize > 0)
                            {
                                buffer = new byte[fileSize];
                                fileSize = inputStream.read(buffer);
                            }
                        }
                        catch (Exception ignored)
                        {}

                        if (fileSize > 0 && buffer != null)
                        {
                            output.write(buffer);
                        }
                        output.write(System.lineSeparator().getBytes());
                        //output.newLine();
                    }
                    //output.flush();
                    //output.close();
                }
                catch (Exception e)
                {}
            }

        }
    }

    private static ArrayList<File> getAllFilesInDir(File dir)
    {
        ArrayList<File> allFiles = new ArrayList<>();
        for (File file : dir.listFiles())
        {
            if (file.isDirectory())
                allFiles.addAll(getAllFilesInDir(file));
            else if (file.isFile())
                allFiles.add(file);
        }
        return allFiles;
    }

    private static void delEmptySubDirs(File dir)
    {
        for (File file : dir.listFiles())
        {
            if (file.isDirectory())
            {
                if (file.listFiles().length == 0)
                    file.delete();
                else
                {
                    delEmptySubDirs(file);
                    if (file.listFiles().length == 0)
                        file.delete();
                }
            }
        }
    }

}
