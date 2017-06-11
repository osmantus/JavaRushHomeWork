package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ConcurrentModificationException;
import java.util.ResourceBundle;

/**
 * Created by Alex on 08.12.2016.
 */
class DepositCommand implements Command
{
    private Command command;
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));

        String currencyCode = ConsoleHelper.askCurrencyCode();


        if (currencyCode != null)
        {
            try
            {
                String[] currencyNominal = ConsoleHelper.getValidTwoDigits(currencyCode);

                if (currencyNominal != null)
                {
                    if (currencyNominal.length == 2)
                    {
                        CurrencyManipulator curManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
                        if (curManipulator != null)
                        {
                            long sum = Integer.parseInt(currencyNominal[0]) * Integer.parseInt(currencyNominal[1]);

                            curManipulator.addAmount(Integer.parseInt(currencyNominal[0]), Integer.parseInt(currencyNominal[1]));

                            ConsoleHelper.writeMessage(res.getString("success.format"), sum, currencyCode);
                        }
                    }
                }
            }
            catch (InterruptOperationException e)
            {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }
            catch (ConcurrentModificationException e)
            {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }
        }
    }
}
