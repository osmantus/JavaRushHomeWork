package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Alex on 04.12.2016.
 */
public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<Integer, Integer>();

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count)
    {
        if (denomination > 0 && count >= 0)
        {
            try
            {
                if (denominations.containsKey(denomination))
                    denominations.put(denomination, denominations.get(denomination) + count);
                else
                    denominations.put(denomination, count);
            }
            catch (ConcurrentModificationException e)
            {
                throw e;
            }
        }
        else
            try
            {
                throw new InterruptOperationException();
            }
            catch (InterruptOperationException e)
            {}
    }

    public int getTotalAmount()
    {
        int result = 0;
        for (Map.Entry<Integer, Integer> eachDenom : denominations.entrySet())
        {
            result = result + eachDenom.getKey() * eachDenom.getValue();
        }
        return result;
    }

    public boolean hasMoney()
    {
        if (getTotalAmount() > 0)
            return true;
        else
            return false;
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        if (getTotalAmount() >= expectedAmount)
            return true;
        else
            return false;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        int balance = expectedAmount;
        int denomCost = 0;

        Map<Integer, Integer> sortedDenoms = new LinkedHashMap<>();

        Map<Integer, Integer> gottenCurrencyByDenom = new HashMap<>();
        int currentDenomCount = 0;

        try
        {
            List<Map.Entry<Integer, Integer>> listForMap = new LinkedList<Map.Entry<Integer, Integer>>(denominations.entrySet());
            Collections.sort(listForMap, new Comparator<Map.Entry<Integer, Integer>>()
            {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)
                {
                    return o2.getKey() - o1.getKey();
                }
            });

            for (Map.Entry<Integer, Integer> entry : listForMap)
            {
                sortedDenoms.put(entry.getKey(), entry.getValue());
            }

            for (Map.Entry<Integer, Integer> denom : sortedDenoms.entrySet())
            {
                denomCost = denom.getKey();
                if (balance >= denomCost)
                {
                    while (denom.getValue() > 0)
                    {
                        balance = balance - denomCost;
                        denom.setValue(denom.getValue() - 1);

                        if (gottenCurrencyByDenom.containsKey(denomCost))
                        {
                            currentDenomCount = gottenCurrencyByDenom.get(denomCost);
                            gottenCurrencyByDenom.put(denomCost, currentDenomCount + 1);
                        } else
                        {
                            gottenCurrencyByDenom.put(denomCost, 1);
                        }

                        if (balance < denomCost)
                        {
                            break;
                        }
                    }
                } else
                {
                    continue;
                }
            }
        }
        catch (ConcurrentModificationException e)
        {
            throw e;
        }

        if (balance > 0)
            throw new NotEnoughMoneyException();

        for (Map.Entry<Integer, Integer> denom : sortedDenoms.entrySet())
        {
            Integer key = denom.getKey();
            Integer value = denom.getValue();
            if (denominations.containsKey(key))
                denominations.put(key, value);
        }

        return gottenCurrencyByDenom;
    }
}
