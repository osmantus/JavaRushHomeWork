package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable
{
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws IOException
    {
        stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException
    {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException
    {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        in.defaultReadObject();
        if (stream == null)
            stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception
    {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception
    {
        Solution sol = new Solution("D:\\Work\\Java\\L20Les10T7\\test.txt");
        sol.writeObject("Test String");
        sol.close();

        ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("D:\\Work\\Java\\L20Les10T7\\objdata.txt"));
        outStream.writeObject(sol);

        //Solution sol2 = new Solution("D:\\Work\\Java\\L20Les10T7\\test.txt", true);
        ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("D:\\Work\\Java\\L20Les10T7\\objdata.txt"));
        //Solution sol2 = new Solution("D:\\Work\\Java\\L20Les10T7\\test.txt", true);
        Solution sol2 = (Solution) inStream.readObject();

        sol2.writeObject("New Second String");

        sol2.close();
    }
}
