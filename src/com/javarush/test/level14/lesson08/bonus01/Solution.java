package com.javarush.test.level14.lesson08.bonus01;

import javax.activation.UnsupportedDataTypeException;
import javax.print.PrintException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions() throws ClassCastException
    {   //it's first exception

        class SomeClass2
        {
            void func(SomeClass2 obj2) {
                obj2.func(obj2);
            }
        }

        /*double mathResult1, mathResult2;
        double result4, result3;
        short shortI = 0;*/

        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            int[] array = {1, 2};
            array[2] = 0;
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            FileInputStream inStream = new FileInputStream("");
            inStream.read();
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            class SomeClass
            {
            }
            SomeClass obj = null;
            System.out.println(obj.toString());
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            FileOutputStream outStream = new FileOutputStream("D:\\Work\\Java\\1.txt");
            byte[] byteArray = new byte[0];
            byteArray[0] = 0;
            outStream.write(byteArray);
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            //mathResult1 = Math.sin(2.0);
            ClassCastException e = new ClassCastException();
            throw e;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            //mathResult2 = Math.sqrt(-1.0);
            CharConversionException e = new CharConversionException();
            throw e;

        } catch (CharConversionException e)
        {
            exceptions.add((Exception) e);
        }

        try
        {
            /*double a = 200000000000000000.0;
            double b = 200000000000000000.0;
            result4 = Math.pow(a, b);*/
            EOFException e = new EOFException();
            throw e;

        } catch (EOFException e)
        {
            exceptions.add((Exception) e);
        }

        try
        {
            /*int a = 2000000000;
            int b = 2000000000;
            int c = a + b;
            double d = 1.0 / c;*/
            UnsupportedDataTypeException e = new UnsupportedDataTypeException();
            throw e;

        } catch (UnsupportedDataTypeException e)
        {
            exceptions.add((Exception) e);
        }

        try
        {
            /*SomeClass2 obj2 = new SomeClass2();
            obj2.func(obj2);*/
            PrintException e = new PrintException();
            throw e;

        } catch (Exception e)
        {
            exceptions.add((Exception) e);
        }

    }
}
