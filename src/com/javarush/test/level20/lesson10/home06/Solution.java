package com.javarush.test.level20.lesson10.home06;

import java.io.*;

/* Запрет сериализации
Запретите сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {

        private void writeObject(java.io.ObjectOutputStream out) throws IOException
        {
            throw new NotSerializableException();
        }

        private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException
        {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) throws Exception
    {
        SubSolution subObj = new SubSolution();

        ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("D:\\Work\\Java\\L20Les10T6\\test.txt"));

        try
        {
            subObj.writeObject(outStream);
        }
        catch (NotSerializableException e)
        {
            e.printStackTrace();
        }

        outStream.close();

        ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("D:\\Work\\Java\\L20Les10T6\\test.txt"));

        try
        {
            subObj.readObject(inStream);
        }
        catch (NotSerializableException e)
        {
            e.printStackTrace();
        }

        inStream.close();
    }

}
