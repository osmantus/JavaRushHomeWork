package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        FileInputStream inStream = new FileInputStream("D:\\Work\\Java\\L20Les7T4\\test.txt");
        FileOutputStream outStream = new FileOutputStream("D:\\Work\\Java\\L20Les7T4\\test.txt");

        ObjectOutputStream objOutStream = new ObjectOutputStream(outStream);
        ObjectInputStream objInStream = new ObjectInputStream(inStream);

        Solution savedObject = new Solution(10);
        objOutStream.writeObject(savedObject);
        objOutStream.close();

        Solution loadedObject = new Solution(5);
        loadedObject = (Solution) objInStream.readObject();
        objInStream.close();

        if (savedObject.toString().equals(loadedObject.toString()))
           System.out.println("OK");
        else
           System.out.println("");

        inStream.close();
        outStream.close();
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient  int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}

