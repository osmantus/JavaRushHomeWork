package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        int id = 0;
        String name = "";
        char sexValue = 0;
        String bd = "";

        if (args.length > 0)
        {
            if (args[0].equals("-c"))
            {
                if (args.length == 4)
                {
                    try
                    {
                        name = args[1];
                        sexValue = args[2].charAt(0);
                        bd = args[3];

                        Date date = new Date();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                        try
                        {
                            date = dateFormat.parse(bd);
                        }
                        catch (ParseException e)
                        {
                            e.printStackTrace();
                        }

                        if (sexValue == 'м')
                            allPeople.add(Person.createMale(name, date));
                        else if (sexValue == 'ж')
                            allPeople.add(Person.createFemale(name, date));

                        System.out.println(allPeople.size()-1);
                    }
                    catch (Exception e)
                    {}
                }
            } else if (args[0].equals("-u"))
            {
                if (args.length == 5)
                {
                    try
                    {
                        id = Integer.parseInt(args[1]);
                        name = args[2];
                        sexValue = args[3].charAt(0);
                        bd = args[4];

                        if (id >= 0 && id < allPeople.size())
                        {
                            Person person = allPeople.subList(id, id + 1).get(0);
                            if (person != null)
                            {
                                person.setName(name);
                                if (sexValue == 'м')
                                    person.setSex(Sex.MALE);
                                else if (sexValue == 'ж')
                                    person.setSex(Sex.FEMALE);

                                Date date = new Date();
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                                try
                                {
                                    date = dateFormat.parse(bd);
                                }
                                catch (ParseException e)
                                {
                                    e.printStackTrace();
                                }

                                person.setBirthDay(date);
                            }
                        }
                    }
                    catch (Exception e)
                    {}
                }
            } else if (args[0].equals("-d"))
            {
                if (args.length == 2)
                {
                    try
                    {
                        id = Integer.parseInt(args[1]);
                        if (id >= 0 && id < allPeople.size())
                        {
                            Person person = allPeople.subList(id, id + 1).get(0);
                            if (person != null)
                            {
                                person.setName(null);
                                person.setSex(null);
                                person.setBirthDay(null);
                            }
                        }
                    }
                    catch (Exception e)
                    {}
                }
            } else if (args[0].equals("-i"))
            {
                if (args.length == 2)
                {
                    try
                    {
                        id = Integer.parseInt(args[1]);
                        if (id >= 0 && id < allPeople.size())
                        {
                            Person person = allPeople.subList(id, id + 1).get(0);
                            if (person != null)
                            {
                                name = person.getName();
                                if (person.getSex() == Sex.MALE)
                                    sexValue = 'м';
                                else if (person.getSex() == Sex.FEMALE)
                                    sexValue = 'ж';
                                Date date = person.getBirthDay();

                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

                                System.out.println(name + " " + sexValue + " " + dateFormat.format(date));
                            }
                        }
                    }
                    catch (Exception e)
                    {}
                }
            }
        }
    }
}
