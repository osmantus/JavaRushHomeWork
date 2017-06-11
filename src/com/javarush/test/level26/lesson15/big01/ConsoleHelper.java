package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.*;
import java.util.ResourceBundle;

/**
 * Created by Alex on 04.12.2016.
 */
public class ConsoleHelper
{
    private static BufferedReader concoleBR = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle commonRes = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    public static void writeMessage(String message, Object... args)
    {
        //System.out.println(message);
        System.out.printf(message, args);
        System.out.println();
    }

    public static String readString() throws InterruptOperationException
    {
        String str = "";
        try
        {
            str = concoleBR.readLine();
        }
        catch (IOException e)
        {}

        if (str.equalsIgnoreCase("exit"))
            throw new InterruptOperationException();

        return str;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        String curCode = null;
        while (true)
        {
            //writeMessage("Введите код валюты: ");
            writeMessage(commonRes.getString("choose.currency.code"));
            curCode = readString();

            if (curCode.length() != 3)
                writeMessage("Неверный код валюты!");
            else
            {
                curCode = curCode.toUpperCase();
                break;
            }
        }
        return curCode;
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        String inputString = null;
        String[] result = null;

        /*while (true)
        {*/
            //writeMessage("Введите номинал валюты и кол-во банкнот: ");
            writeMessage(commonRes.getString("choose.denomination.and.count.format"), currencyCode);
            inputString = readString().trim();

            if (inputString.contains(" "))
            {
                int pos = inputString.indexOf(" ");
                String curNominal = inputString.substring(0, pos);
                String curAmount = inputString.substring(pos+1, inputString.length());

                if (curNominal.matches("\\d+") && curAmount.matches("\\d+"))
                {
                    int curNominalInt = Integer.parseInt(curNominal);
                    int curAmountInt = Integer.parseInt(curAmount);

                    if (curNominalInt <= 0 || curAmountInt <= 0)
                    {
                        if (curNominalInt <= 0)
                        {
                            //writeMessage("Неверный номинал валюты!");
                            throw new InterruptOperationException();
                        }
                        if (curAmountInt <= 0)
                        {
                            //writeMessage("Неверное кол-во банкнот!");
                            throw new InterruptOperationException();
                        }
                    } else
                    {
                        result = new String[]{curNominal, curAmount};
                        //break;
                    }
                }
                else
                {
                    //writeMessage("Неверный номинал валюты и/или кол-во банкнот!");
                    //continue;
                    throw new InterruptOperationException();
                }
            }
            else
            {
                //writeMessage("Неверный номинал валюты и/или кол-во банкнот!");
                //continue;
                throw new InterruptOperationException();
            }
        //}

        return result;
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        Operation operation = null;
        int opCode = 0;

        do
        {
            //writeMessage("Введите код операции:");
            writeMessage(commonRes.getString("choose.operation"));

            try
            {
                opCode = Integer.parseInt(readString());
                operation = Operation.getAllowableOperationByOrdinal(opCode);

                switch (operation)
                {
                    case INFO:
                        writeMessage(commonRes.getString("operation.INFO"));
                        break;
                    case DEPOSIT:
                        writeMessage(commonRes.getString("operation.DEPOSIT"));
                        break;
                    case WITHDRAW:
                        writeMessage(commonRes.getString("operation.WITHDRAW"));
                        break;
                    case EXIT:
                        writeMessage(commonRes.getString("operation.EXIT"));
                }

                break;
            }
            catch (IllegalArgumentException e)
            {
                //writeMessage("Неверно введён код операции.");
                writeMessage(commonRes.getString("invalid.data"));
            }
            catch (Exception e)
            {}
        } while (operation != Operation.EXIT);

        //writeMessage(commonRes.getString("the.end"));

        return operation;
    }

    public static void printExitMessage() throws InterruptOperationException
    {
        writeMessage(commonRes.getString("the.end"));
    }
}
