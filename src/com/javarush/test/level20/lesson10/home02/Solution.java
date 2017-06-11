package com.javarush.test.level20.lesson10.home02;

import java.io.*;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) throws Exception {

        Object object = objectStream.readObject();
        if (object instanceof B)
            return (B) object;
        else if (object instanceof A)
            return (A) object;
        else
            return null;
    }

    public class A implements Serializable
    {
        private void writeObject(ObjectOutputStream out) throws IOException
        {}

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
        {}
    }

    public class B extends A
    {
        public B() {
            System.out.println("inside B");
        }

        private void writeObject(ObjectOutputStream out) throws IOException
        {}

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
        {}
    }

}
