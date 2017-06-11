package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * Created by Alex on 16.12.2016.
 */
public class LoginCommand implements Command
{
    private Command command;
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        String cardNumber;
        String cardPIN;
        long cardNumberLong;
        int cardPINInt;

        ConsoleHelper.writeMessage(res.getString("before"));

        Set<String> resKeysIDs = validCreditCards.keySet();
        HashMap<String, String> resStrByKeys = new HashMap<>();

        for (String key : resKeysIDs)
        {
            resStrByKeys.put(key, validCreditCards.getString(key));
        }

        ConsoleHelper.writeMessage(res.getString("specify.data"));
        do
        {
            //ConsoleHelper.writeMessage("Введите последовательно 2 числа (номер карты и пин):");
            //ConsoleHelper.writeMessage(res.getString("specify.data"));
            cardNumber = ConsoleHelper.readString().trim();
            cardPIN = ConsoleHelper.readString().trim();

            if (cardNumber.matches("\\d{12}?") && cardPIN.matches("\\d{4}?"))
            {
                cardNumberLong = Long.parseLong(cardNumber);
                cardPINInt = Integer.parseInt(cardPIN);

                if (cardNumberLong <= 0 || cardPINInt <= 0)
                {
                    if (cardNumberLong <= 0)
                    {
                        //ConsoleHelper.writeMessage("Неверный номер карты!");
                        ConsoleHelper.writeMessage(res.getString("not.verified.format"), cardNumber);
                    }
                    if (cardPINInt <= 0)
                    {
                        //ConsoleHelper.writeMessage("Неверный пин!");
                        ConsoleHelper.writeMessage(res.getString("not.verified.format"), cardNumber);
                    }
                } else
                {
                    if (resStrByKeys.containsKey(cardNumber))
                    {
                        if (resStrByKeys.get(cardNumber).equals(cardPIN))
                        {
                            //ConsoleHelper.writeMessage("Данные идентифицированы.");
                            ConsoleHelper.writeMessage(res.getString("success.format"), cardNumber);
                            break;
                        }
                        else
                        {
                            //ConsoleHelper.writeMessage("Неверный пин!");
                            ConsoleHelper.writeMessage(res.getString("not.verified.format"), cardNumber);
                            continue;
                        }
                    }
                    else
                    {
                        //ConsoleHelper.writeMessage("Неверный номер карты!");
                        ConsoleHelper.writeMessage(res.getString("not.verified.format"), cardNumber);
                        continue;
                    }
                }
            } else
            {
                //ConsoleHelper.writeMessage("Неверный номер карты и/или пин!");
                ConsoleHelper.writeMessage(res.getString("not.verified.format"), cardNumber);
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }

            ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));

        } while (true);
    }
}
