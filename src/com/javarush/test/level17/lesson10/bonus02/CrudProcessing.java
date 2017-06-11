package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Alex on 03.07.2016.
 */
public class CrudProcessing extends Thread
{
    private int processingStatus;
    private int id;
    private String name;
    private char sexValue;
    private String bd;

    public void initialize(int id, String name, char sexValue, String bd)
    {
        this.id = id;
        this.name = name;
        this.sexValue = sexValue;
        this.bd = bd;
    }

    public void setProcessing(int processingStatus)
    {
        this.processingStatus = processingStatus;
    }

    public int getProcessingStatus()
    {
        return processingStatus;
    }

    @Override
    public void run()
    {
        int procStatus = getProcessingStatus();
        if (procStatus == 0)
        {
            createPerson();
            /*Person person = Solution.allPeople.get(Solution.allPeople.size()-1);
            System.out.println(person.getName() + " - " + person.getSex() + " - " + person.getBirthDay());*/
        }
        else if (procStatus == 1)
        {
            updatePerson();
            /*Person person = Solution.allPeople.get(this.id);
            System.out.println(person.getName() + " - " + person.getSex() + " - " + person.getBirthDay());*/
        }
        else if (procStatus == 2)
            deletePerson();
        else if (procStatus == 3)
            infoAboutPerson();
    }

    public synchronized void createPerson()
    {
        try
        {
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
                Solution.allPeople.add(Person.createMale(name, date));
            else if (sexValue == 'ж')
                Solution.allPeople.add(Person.createFemale(name, date));

            System.out.println(Solution.allPeople.size()-1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public synchronized void updatePerson()
    {
        try
        {
            if (id >= 0 && id < Solution.allPeople.size())
            {
                Person person = Solution.allPeople.subList(id, id + 1).get(0);
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
        {
            e.printStackTrace();
        }
    }

    public synchronized void deletePerson()
    {
        try
        {
            if (id >= 0 && id < Solution.allPeople.size())
            {
                Person person = Solution.allPeople.subList(id, id + 1).get(0);
                if (person != null)
                {
                    person.setName(null);
                    person.setSex(null);
                    person.setBirthDay(null);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void infoAboutPerson()
    {
        String name = "";
        char sexValue = 0;
        Date date;
        SimpleDateFormat dateFormat;

        try
        {
            if (id >= 0 && id < Solution.allPeople.size())
            {
                Person person = Solution.allPeople.subList(id, id + 1).get(0);
                if (person != null)
                {
                    name = person.getName();
                    if (person.getSex() == Sex.MALE)
                        sexValue = 'м';
                    else if (person.getSex() == Sex.FEMALE)
                        sexValue = 'ж';
                    date = person.getBirthDay();

                    dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

                    System.out.println(name + " " + sexValue + " " + dateFormat.format(date));
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
