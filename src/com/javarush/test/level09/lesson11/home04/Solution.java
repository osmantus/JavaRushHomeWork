package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputTxt;
        Date date = new Date();
        int year, month, day;
        //Locale.setDefault(Locale.US);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        //dateFormat.applyLocalizedPattern("dd/MM/yyyy");

        try
        {
            inputTxt = reader.readLine();
            date = dateFormat.parse(inputTxt);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        dateFormat.applyPattern("MMM dd, yyyy");
        //dateFormat.format(date);
        System.out.println(dateFormat.format(date).toUpperCase());
    }
}
