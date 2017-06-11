package com.javarush.test.level20.lesson02.task04;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Properties;

/* Читаем и пишем в файл статики
Реализуйте логику записи в файл и чтения из файла для класса ClassWithStatic
Метод load должен инициализировать объект включая статические поля данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            String your_file_name = "D:\\Work\\Java\\L20Les1T4\\sample.tmp";
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            //File your_file_name = File.createTempFile("your_file_name", null);
            //OutputStream outputStream = new FileOutputStream(your_file_name);
            //InputStream inputStream = new FileInputStream(your_file_name);

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();

            ClassWithStatic loadedObject = new ClassWithStatic();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            loadedObject.load(inputStream);
            //check here that classWithStatic object equals to loadedObject object - проверьте тут, что classWithStatic и loadedObject равны

            System.out.println(ClassWithStatic.staticString);

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (IllegalArgumentException e) {
            System.out.println("Error in object type of argument.");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class ClassWithStatic {
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            Properties properties = new Properties();

            Field[] fields = this.getClass().getDeclaredFields();
            Field field = null;

            String propName = null;
            String propValue = null;

            for (int k = 0; k < fields.length; k++)
            {
                field = fields[k];
                propName = field.getName();
                propValue = String.valueOf(field.get(this));

                properties.setProperty(propName, propValue);
            }

            properties.store(outputStream, null);
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            Properties properties = new Properties();
            Object propValObj = null;

            Field field = null;

            String propName = null;
            String propValue = null;

            Object nativeObj = null;
            String fieldClassName = null;

            properties.load(inputStream);
            for (String eachPropertyName : properties.stringPropertyNames())
            {
                propName = eachPropertyName;
                propValObj = properties.getProperty(eachPropertyName);

                field = this.getClass().getField(propName);
                if (field != null)
                {
                    if (Modifier.isStatic(field.getModifiers()))
                        nativeObj = null;
                    else
                        nativeObj = this;

                    fieldClassName = field.getType().getSimpleName();

                    if (fieldClassName.equals("int"))
                        field.set(nativeObj, Integer.parseInt((String) propValObj));
                    else if (fieldClassName.equals("Integer"))
                        field.set(nativeObj, Integer.valueOf((String) propValObj));

                    else if (fieldClassName.equals("String"))
                        field.set(nativeObj, (String) propValObj);

                    else if (fieldClassName.equals("boolean"))
                        field.set(nativeObj, Boolean.parseBoolean((String) propValObj));
                    else if (fieldClassName.equals("Boolean"))
                        field.set(nativeObj, Boolean.valueOf((String) propValObj));

                    else if (fieldClassName.equals("byte"))
                        field.set(nativeObj, Byte.parseByte((String) propValObj));
                    else if (fieldClassName.equals("Byte"))
                        field.set(nativeObj, Byte.valueOf((String) propValObj));

                    else if (fieldClassName.equals("char"))
                        field.set(nativeObj, ((String) propValObj).charAt(0));

                    else if (fieldClassName.equals("double"))
                        field.set(nativeObj, Double.parseDouble((String) propValObj));
                    else if (fieldClassName.equals("Double"))
                        field.set(nativeObj, Double.valueOf((String) propValObj));

                    else if (fieldClassName.equals("float"))
                        field.set(nativeObj, Float.parseFloat((String) propValObj));
                    else if (fieldClassName.equals("Float"))
                        field.set(nativeObj, Float.valueOf((String) propValObj));

                    else if (fieldClassName.equals("long"))
                        field.set(nativeObj, Long.parseLong((String) propValObj));
                    else if (fieldClassName.equals("Long"))
                        field.set(nativeObj, Long.valueOf((String) propValObj));

                    else if (fieldClassName.equals("short"))
                        field.set(nativeObj, Short.parseShort((String) propValObj));
                    else if (fieldClassName.equals("Short"))
                        field.set(nativeObj, Short.valueOf((String) propValObj));
                }
            }
        }
    }
}
