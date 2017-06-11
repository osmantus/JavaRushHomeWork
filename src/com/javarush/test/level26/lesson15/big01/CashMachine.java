package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Alex on 04.12.2016.
 */
public class CashMachine
{
    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ENGLISH);

        Operation op;

        try
        {
            CommandExecutor.execute(Operation.LOGIN);

            while (true)
            {
                ConsoleHelper.writeMessage("Выберите операцию:");
                String commandStr = ConsoleHelper.readString();

                int commandID = Integer.parseInt(commandStr);

                try
                {
                    op = Operation.getAllowableOperationByOrdinal(commandID);
                }
                catch (IllegalArgumentException e)
                {
                    continue;
                }

                try
                {
                    CommandExecutor.execute(op);
                }
                catch (InterruptOperationException e)
                {
                    break;
                }
            }
        }
        catch (InterruptOperationException e)
        {}
        //ConsoleHelper.writeMessage("До свидания!");
        //ConsoleHelper.writeMessage(ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en").getString("the.end"));
    }
}
