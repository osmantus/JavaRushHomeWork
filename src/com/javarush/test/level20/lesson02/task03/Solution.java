package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public static void main(String args[])
    {
        Solution someObject = new Solution();
        someObject.fillInPropertiesMap();

        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();

            FileOutputStream fileOutput = new FileOutputStream(fileName);
            someObject.save(fileOutput);
            fileOutput.close();

            reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();

            FileInputStream fileInput = new FileInputStream(fileName);
            someObject.load(fileInput);
            fileInput.close();
        }
        catch (Exception e)
        {}
    }

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод

        BufferedReader reader = null;

        FileInputStream fileInput = null;

        try
        {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String fileSource = reader.readLine();

            fileInput = new FileInputStream(fileSource);
            load(fileInput);
            fileInput.close();
        }
        catch (Exception e)
        {}
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод

        /*
        byte[] strToBytes = null;
        for (Map.Entry<String, String> eachElement : properties.entrySet())
        {
            strToBytes = eachElement.getKey().getBytes();
            outputStream.write(strToBytes);
            outputStream.write('=');
            strToBytes = eachElement.getValue().getBytes();
            outputStream.write(strToBytes);
            outputStream.write('\n');
        }
        outputStream.flush();*/

        Properties propertiesLocal = new Properties();

        for (Map.Entry<String, String> eachElement : properties.entrySet())
            propertiesLocal.setProperty(eachElement.getKey(), eachElement.getValue());
        propertiesLocal.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод

        /*int byteVar = 0;

        String bytesStr = "";

        boolean lineIsComment = false;

        String key = null, value = null;

        while (inputStream.available() > 0)
        {
            byteVar = inputStream.read();

            if (lineIsComment == true)
            {
                if (byteVar == '\r' || byteVar == '\n')
                {
                    if (byteVar == '\r')
                    {
                        if (inputStream.available() > 0)
                        {
                            byteVar = inputStream.read();
                            if (byteVar != '\n')
                            {
                                lineIsComment = false;
                                bytesStr = String.valueOf((char) byteVar);
                                continue;

                            } else
                            {
                                lineIsComment = false;
                                continue;
                            }
                        }
                    }
                    else if (byteVar == '\n')
                    {
                        lineIsComment = false;
                        continue;
                    }
                }
                else
                    continue;
            }

            if (byteVar == '#' || byteVar == '!')
            {
                lineIsComment = true;
                continue;
            }

            if (byteVar == '=' || byteVar == ' ' || byteVar == ':')
            {
                key = bytesStr.trim();
                bytesStr = "";
            }
            else if (byteVar == '\r' || byteVar == '\n')
            {
                if (byteVar == '\r')
                {
                    if (inputStream.available() > 0)
                    {
                        byteVar = inputStream.read();
                        if (byteVar != '\n')
                        {
                            value = bytesStr.trim();
                            properties.put(key, value);
                            bytesStr = "";

                            bytesStr = bytesStr.concat(String.valueOf((char) byteVar));
                        }
                        else
                        {
                            value = bytesStr.trim();
                            properties.put(key, value);
                            bytesStr = "";
                        }
                    }
                }
                else if (byteVar == '\n')
                {
                    value = bytesStr.trim();
                    properties.put(key, value);
                    bytesStr = "";
                }
            }
            else
            {
                bytesStr = bytesStr.concat(String.valueOf((char) byteVar));
            }
        }

        if (!key.equals(""))
        {
            value = bytesStr;
            properties.put(key, value);
        }
        */

        Properties propertiesLocal = new Properties();
        String propertyValue = null;

        propertiesLocal.load(inputStream);
        for (String eachPropertyName : propertiesLocal.stringPropertyNames())
        {
            propertyValue = propertiesLocal.getProperty(eachPropertyName);
            properties.put(eachPropertyName, propertyValue);
        }
    }
}
