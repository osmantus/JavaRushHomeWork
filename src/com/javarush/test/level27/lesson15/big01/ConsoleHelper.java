package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 22.12.2016.
 */
public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws IOException
    {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException
    {
        List<Dish> list = new ArrayList<>();

        writeMessage("Выберите блюда (" + Dish.allDishesToString() + "): ");
        //writeMessage(Dish.allDishesToString());

        String inputLine = "";
        while (!(inputLine = readString()).equalsIgnoreCase("exit")) {
            try {
                list.add(Dish.valueOf(inputLine));
            } catch (IllegalArgumentException e) {
                writeMessage(inputLine + " is not detected");
            }
        }
        return list;
    }
}
