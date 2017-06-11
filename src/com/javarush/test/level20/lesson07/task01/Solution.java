package com.javarush.test.level20.lesson07.task01;

import java.io.*;

/* Externalizable для апартаментов
Реализуйте интерфейс Externalizable для класса Apartment
Подумайте, какие поля не нужно сериализовать.
*/
public class Solution {

    public static class Apartment implements Externalizable
    {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String adr, int y) {
            address = adr;
            year = y;
        }

        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException
        {
            out.writeObject(address);
            out.writeObject(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
        {
            address = (String) in.readObject();
            year = (int) in.readObject();
        }
    }

    public static void main(String[] args)
    {
        Apartment apartment = new Apartment("Адрес1", 5);

        System.out.println(apartment);
        try
        {
            FileOutputStream outStream = new FileOutputStream("D:\\Work\\Java\\L20Les7T1\\exchange.txt");
            //ObjectOutputStream objectOutput = new ObjectOutputStream(outStream);
            apartment.writeExternal(new ObjectOutputStream(outStream));
            outStream.close();
            //objectOutput.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //Apartment apartment2 = null;
        Apartment apartment2 = new Apartment("", 0);

        try
        {
            FileInputStream inStream = new FileInputStream("D:\\Work\\Java\\L20Les7T1\\exchange.txt");
            //ObjectOutputStream objectOutput = new ObjectOutputStream(outStream);
            //ObjectInputStream in = new ObjectInputStream(inStream);
            apartment2.readExternal(new ObjectInputStream(inStream));
            //apartment2 = (Apartment) in.readObject();
            inStream.close();
            //objectOutput.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(apartment2);
    }
}
