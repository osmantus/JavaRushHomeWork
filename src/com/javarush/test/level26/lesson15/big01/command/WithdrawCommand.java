package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Alex on 08.12.2016.
 */
class WithdrawCommand implements Command
{
    private Command command;
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));

        String currencyCode = ConsoleHelper.askCurrencyCode();
        if (currencyCode != null)
        {
            CurrencyManipulator curManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
            if (curManipulator != null)
            {
                String str = "";
                int sum = 0;
                while (true)
                {
                    //ConsoleHelper.writeMessage("Введите сумму:");
                    ConsoleHelper.writeMessage(res.getString("specify.amount"));
                    str = ConsoleHelper.readString();

                    if (str.matches("\\d+"))
                    {
                        sum = Integer.parseInt(str);
                        if (sum <= 0)
                        {
                            //ConsoleHelper.writeMessage("Введена неверная сумма! Введите положительное значение.");
                            ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                            continue;
                        }
                        else
                        {
                            if (curManipulator.isAmountAvailable(sum))
                            {
                                try
                                {
                                    Map<Integer, Integer> map = curManipulator.withdrawAmount(sum);
                                    if (!map.isEmpty())
                                    {
                                        List<Map.Entry<Integer, Integer>> listForMap = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
                                        Collections.sort(listForMap, new Comparator<Map.Entry<Integer, Integer>>()
                                        {
                                            @Override
                                            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
                                            {
                                                return o2.getKey() - o1.getKey();
                                            }
                                        });

                                        for (Map.Entry<Integer, Integer> eachEntry : listForMap)
                                        {
                                            ConsoleHelper.writeMessage("\t" + eachEntry.getKey() + " - " + eachEntry.getValue());
                                        }
                                        //ConsoleHelper.writeMessage("Транзакция выполнена успешно!");
                                        ConsoleHelper.writeMessage(res.getString("success.format"), sum, currencyCode);
                                        break;
                                    }
                                }
                                catch (NotEnoughMoneyException e)
                                {
                                    //ConsoleHelper.writeMessage("Недостаточно банкнот!");
                                    ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                                    continue;
                                }
                                catch (Exception e)
                                {
                                    throw e;
                                }
                            }
                            else
                            {
                                //ConsoleHelper.writeMessage("Недостаточно средств на счёте.");
                                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                                continue;
                            }
                        }
                    }
                    else
                    {
                        //ConsoleHelper.writeMessage("Введённая строка не может быть преобразована в число.");
                        ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                        continue;
                    }
                }
            }
        }
    }
}
