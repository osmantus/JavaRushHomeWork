package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution {
    public static class A {
        protected String name = "A";

        public A(String name) {
            this.name += name;
        }

        public A()
        {}
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }

        public B()
        {
            super();
        }

        private void writeObject(ObjectOutputStream out) throws IOException
        {
            out.writeObject(name);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
        {
            name = (String) in.readObject();
        }
    }

    public static void main(String[] args) throws Exception
    {
        try
        {
            Solution sol = new Solution();
            B bObj = sol.new B("");

            ObjectOutputStream objOutStream = new ObjectOutputStream(new FileOutputStream("D:\\Work\\Java\\L20Les10T3\\test.txt"));
            bObj.writeObject(objOutStream);

            B bObj2 = sol.new B("");

            ObjectInputStream objInStream = new ObjectInputStream(new FileInputStream("D:\\Work\\Java\\L20Les10T3\\test.txt"));
            bObj2.readObject(objInStream);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
