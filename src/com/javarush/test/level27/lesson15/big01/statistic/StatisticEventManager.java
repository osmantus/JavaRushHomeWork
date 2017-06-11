package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Alex on 03.01.2017.
 */
public class StatisticEventManager
{
    private static StatisticEventManager ourInstance = new StatisticEventManager();
    private static StatisticEventManager.StatisticStorage storage = new StatisticStorage();

    public static StatisticEventManager getInstance()
    {
        return ourInstance;
    }

    private StatisticEventManager()
    {

    }

    private static class StatisticStorage
    {
        private Map<EventType, List<EventDataRow>> eventsMap = new HashMap<>();

        public StatisticStorage()
        {
            for (EventType event : EventType.values())
            {
                this.eventsMap.put(event, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data)
        {
            EventType eventType = data.getType();
            if (eventType != null)
            {
                List<EventDataRow> eventDataRows = this.eventsMap.get(eventType);
                eventDataRows.add(data);
                this.eventsMap.put(eventType, eventDataRows);
            }
        }

        private List<EventDataRow> getEventDataRowsByType(EventType eventType)
        {
            List<EventDataRow> eventDataRows = null;
            if (eventsMap.containsKey(eventType))
            {
                eventDataRows = eventsMap.get(eventType);
            }
            return eventDataRows;
        }
    }

    public void register(EventDataRow data)
    {
        //TODO
        storage.put(data);
    }

    public Map<Date, Long> advertisementProfitByDate()
    {
        List<EventDataRow> eventDataRows = storage.getEventDataRowsByType(EventType.SELECTED_VIDEOS);
        if (eventDataRows != null)
        {
            Map<Date, Long> totalSumFromAdvByDate = null;

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

            for (EventDataRow event : eventDataRows)
            {
                if (event.getType() == EventType.SELECTED_VIDEOS)       //дополнительно проверяем
                {
                    VideoSelectedEventDataRow videoSelectedEvent = (VideoSelectedEventDataRow) event;
                    Date videoShowDate = videoSelectedEvent.getDate();
                    String videoShowDateStr = dateFormat.format(videoShowDate);
                    videoShowDate = dateFormat.parse(videoShowDateStr, new ParsePosition(0));

                    long totalSumFromAdv = 0;
                    if (totalSumFromAdvByDate == null)
                    {
                        totalSumFromAdvByDate = new HashMap<>();
                        totalSumFromAdvByDate.put(videoShowDate, videoSelectedEvent.getAmount());
                    }
                    else
                    {
                        if (totalSumFromAdvByDate.containsKey(videoShowDate))
                        {
                            totalSumFromAdv = totalSumFromAdvByDate.get(videoShowDate);
                            totalSumFromAdv += videoSelectedEvent.getAmount();
                            totalSumFromAdvByDate.put(videoShowDate, totalSumFromAdv);
                        }
                        else
                        {
                            totalSumFromAdvByDate.put(videoShowDate, videoSelectedEvent.getAmount());
                        }
                    }
                }
            }
            return totalSumFromAdvByDate;
        }
        else
            return null;
    }

    public Map<Date, HashMap<String, Integer>> getCookingTimesByDate()
    {
        List<EventDataRow> eventDataRows = storage.getEventDataRowsByType(EventType.COOKED_ORDER);
        if (eventDataRows != null)
        {
            Map<Date, HashMap<String, Integer>> cookingTimesByDate = null;
            HashMap<String, Integer> cookingTimeByOneCook = null;

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

            for (EventDataRow event : eventDataRows)
            {
                if (event.getType() == EventType.COOKED_ORDER)       //дополнительно проверяем
                {
                    CookedOrderEventDataRow cookEvent = (CookedOrderEventDataRow) event;
                    Date cookingDate = cookEvent.getDate();
                    String cookingDateStr = dateFormat.format(cookingDate);
                    cookingDate = dateFormat.parse(cookingDateStr, new ParsePosition(0));

                    String cookName = cookEvent.getCookName();
                    int totalCookingTime = 0;
                    if (cookingTimesByDate == null)
                    {
                        cookingTimesByDate = new HashMap<>();
                        cookingTimeByOneCook = new HashMap<String, Integer>();
                        cookingTimeByOneCook.put(cookName, cookEvent.getTime());
                        cookingTimesByDate.put(cookingDate, cookingTimeByOneCook);
                    }
                    else
                    {
                        if (cookingTimesByDate.containsKey(cookingDate))
                        {
                            cookingTimeByOneCook = cookingTimesByDate.get(cookingDate);
                            if (cookingTimeByOneCook.containsKey(cookName))
                            {
                                totalCookingTime = cookingTimeByOneCook.get(cookName);
                                totalCookingTime += cookEvent.getTime();
                                cookingTimeByOneCook.put(cookName, totalCookingTime);
                            }
                            else
                            {
                                cookingTimeByOneCook.put(cookName, cookEvent.getTime());
                            }
                        }
                        else
                        {
                            cookingTimeByOneCook = new HashMap<String, Integer>();
                            cookingTimeByOneCook.put(cookName, cookEvent.getTime());

                            cookingTimesByDate.put(cookingDate, cookingTimeByOneCook);
                        }
                    }
                }
            }

            return cookingTimesByDate;
        }
        else
            return null;
    }
}
