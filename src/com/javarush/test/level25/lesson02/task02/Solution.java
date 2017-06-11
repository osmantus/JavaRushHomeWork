package com.javarush.test.level25.lesson02.task02;

import java.util.*;

/* Машину на СТО не повезем!
Инициализируйте поле wheels используя данные из loadWheelNamesFromDB.
Обработайте некорректные данные.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws IllegalArgumentException {
            //init wheels here
            String[] array = loadWheelNamesFromDB();

            if (array != null)
            {
                wheels = new ArrayList<>();
                for (int i = 0; i < array.length; i++)
                {
                    try
                    {
                        wheels.add(Wheel.valueOf(array[i]));
                    }
                    catch (IllegalArgumentException e)
                    {
                        throw new IllegalArgumentException();
                    }
                }
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT", "TEST"};
        }
    }

    public static void main(String[] args)
    {
        try
        {
            Car newCar = new Car();
        }
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }
    }
}
