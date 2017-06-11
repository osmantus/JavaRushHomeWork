package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Alex on 08.12.2016.
 */
class InfoCommand implements Command
{
    private Command command;
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));

        Collection<CurrencyManipulator> manCollections = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        boolean hasMoney = false;

        if (manCollections.size() > 0)
        {
            Iterator<CurrencyManipulator> iterator = manCollections.iterator();

            while (iterator.hasNext())
            {
                //CurrencyManipulator manipulator = eachManipulatorCover.getValue();
                CurrencyManipulator manipulator = iterator.next();
                if (manipulator.hasMoney())
                {
                    String currency = manipulator.getCurrencyCode();
                    ConsoleHelper.writeMessage(currency + " - " + manipulator.getTotalAmount());
                    hasMoney = true;
                }
            }
        }
        if (!hasMoney)
            //ConsoleHelper.writeMessage("No money available.");
            ConsoleHelper.writeMessage(res.getString("no.money"));
    }
}
