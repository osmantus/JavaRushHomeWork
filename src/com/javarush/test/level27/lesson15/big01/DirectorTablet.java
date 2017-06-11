package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;
import com.javarush.test.level27.lesson15.big01.ad.StatisticAdvertisementManager;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Alex on 03.01.2017.
 */
public class DirectorTablet
{
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");

    public void printAdvertisementProfit()
    {
        StatisticEventManager statisticEventManager = StatisticEventManager.getInstance();
        Map<Date, Long> advProfitByDate = statisticEventManager.advertisementProfitByDate();

        if (advProfitByDate != null)
        {
            Comparator<Date> comparatorOnDate = new Comparator<Date>()
            {
                @Override
                public int compare(Date o1, Date o2)
                {
                    int result = o2.compareTo(o1);
                    return result;
                }
            };

            SortedMap<Date, Long> sortedAdvProfitByDate = new TreeMap<>(comparatorOnDate);
            for (Map.Entry<Date, Long> advProfitEntry : advProfitByDate.entrySet())
            {
                sortedAdvProfitByDate.put(advProfitEntry.getKey(), advProfitEntry.getValue());
            }

            //SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            DecimalFormat decimalFormat = new DecimalFormat();
            DecimalFormatSymbols decimalSymbols = decimalFormat.getDecimalFormatSymbols();
            decimalSymbols.setDecimalSeparator('.');
            decimalFormat.setMinimumFractionDigits(2);
            decimalFormat.setMaximumFractionDigits(2);
            decimalFormat.setDecimalFormatSymbols(decimalSymbols);

            double totalAmount = 0;
            for (Map.Entry<Date, Long> eachAdvProfitEntry : sortedAdvProfitByDate.entrySet())
            {
                Date date = eachAdvProfitEntry.getKey();
                double amount = (double) eachAdvProfitEntry.getValue() / 100;
                //String dateStr = dateFormat.format(date);
                String dateStr = DATE_FORMAT.format(date);

                String amountConv = decimalFormat.format(amount);

                //System.out.format("%s - %s\n", dateStr, amountConv);
                ConsoleHelper.writeMessage(String.format("%s - %s", dateStr, amountConv));
                //ConsoleHelper.writeMessage(String.format("%s - %.2f", dateStr, amount));

                //System.out.format("%s - %.2f\n", dateFormat.format(date), amount);
                //System.out.println(dateFormat.format(date) + " - " + amount);
                //totalAmount += amount;
                totalAmount += eachAdvProfitEntry.getValue();
            }
            String totalAmountConv = decimalFormat.format((double) totalAmount / 100);


            /*System.out.format("Total - %s\n", totalAmountConv);
            System.out.println();*/

            ConsoleHelper.writeMessage(String.format("Total - %s", totalAmountConv));
            //ConsoleHelper.writeMessage(String.format("Total - %.2f", totalAmount));
            ConsoleHelper.writeMessage("");

            //System.out.format("Total - %.2f\n", totalAmount);
        }
        /*else
        {
            ConsoleHelper.writeMessage(String.format("Total - 0.00"));
            ConsoleHelper.writeMessage("");
        }*/
    }

    public void printCookWorkloading()
    {
        StatisticEventManager statisticEventManager = StatisticEventManager.getInstance();
        Map<Date, HashMap<String, Integer>> cookingTimePerCookByDate = statisticEventManager.getCookingTimesByDate();

        if (cookingTimePerCookByDate != null)
        {
            Comparator<Date> comparatorOnDate = new Comparator<Date>()
            {
                @Override
                public int compare(Date o1, Date o2)
                {
                    return o2.compareTo(o1);
                }
            };

            SortedMap<Date, SortedMap<String, Integer>> cookingTimePerCookByDateToBeSorted = new TreeMap<>(comparatorOnDate);

            for (Map.Entry<Date, HashMap<String, Integer>> eachCookingEntry : cookingTimePerCookByDate.entrySet())
            {
                Comparator<String> comparatorOnCookName = new Comparator<String>()
                {
                    @Override
                    public int compare(String o1, String o2)
                    {
                        return o1.compareTo(o2);
                    }
                };

                SortedMap<String, Integer> sortedCookingTimes = new TreeMap<>(comparatorOnCookName);
                HashMap<String, Integer> notSortedCookingTimes = eachCookingEntry.getValue();

                for (Map.Entry<String, Integer> eachCookingTime : notSortedCookingTimes.entrySet())
                {
                    sortedCookingTimes.put(eachCookingTime.getKey(), eachCookingTime.getValue());
                }

                cookingTimePerCookByDateToBeSorted.put(eachCookingEntry.getKey(), sortedCookingTimes);
            }

            //SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

            for (Map.Entry<Date, SortedMap<String, Integer>> eachCookingEntry : cookingTimePerCookByDateToBeSorted.entrySet())
            {
                Date date = eachCookingEntry.getKey();
                //String dateStr = dateFormat.format(date);
                String dateStr = DATE_FORMAT.format(date);

                //System.out.format("%s\n", dateStr);
                //ConsoleHelper.writeMessage(String.format("%s", dateStr));
                ConsoleHelper.writeMessage(dateStr);

                for (Map.Entry<String, Integer> cookingTime : eachCookingEntry.getValue().entrySet())
                {
                    //System.out.format("%s - %d min\n", cookingTime.getKey(), (int) Math.ceil(cookingTime.getValue() / 60));

                    /*int time = cookingTime.getValue();
                    if (time == 0)
                        continue;
                    if (time % 60 == 0)
                        time = time / 60;
                    else
                        time = time / 60 + 1;*/

                    //ConsoleHelper.writeMessage(String.format("%s - %d min", cookingTime.getKey(), time));

                    ConsoleHelper.writeMessage(String.format("%s - %d min", cookingTime.getKey(), (int) Math.ceil(cookingTime.getValue() / 60f)));
                }

                //System.out.println();
                ConsoleHelper.writeMessage("");
            }
        }
    }

    public void printActiveVideoSet()
    {
        StatisticAdvertisementManager statAdvManager = StatisticAdvertisementManager.getInstance();
        if (statAdvManager != null)
        {
            List<Advertisement> advList = statAdvManager.getActiveAdvVideos();
            if (advList != null)
            {
                Comparator<Advertisement> comparatorOnName = new Comparator<Advertisement>()
                {
                    @Override
                    public int compare(Advertisement o1, Advertisement o2)
                    {
                        return (o1.getName()).compareToIgnoreCase(o2.getName());
                    }
                };

                Collections.sort(advList, comparatorOnName);

                for (Advertisement eachAdv : advList)
                {
                    ConsoleHelper.writeMessage(String.format("%s - %d", eachAdv.getName(), eachAdv.getHits()));
                }
            }
        }
    }

    public void printArchivedVideoSet()
    {
        StatisticAdvertisementManager statAdvManager = StatisticAdvertisementManager.getInstance();
        if (statAdvManager != null)
        {
            List<Advertisement> advList = statAdvManager.getInactiveAdvVideos();
            if (advList != null)
            {
                Comparator<Advertisement> comparatorOnName = new Comparator<Advertisement>()
                {
                    @Override
                    public int compare(Advertisement o1, Advertisement o2)
                    {
                        return (o1.getName()).compareToIgnoreCase(o2.getName());
                    }
                };

                Collections.sort(advList, comparatorOnName);

                for (Advertisement eachAdv : advList)
                {
                    ConsoleHelper.writeMessage(eachAdv.getName());
                }
            }
        }
    }
}
