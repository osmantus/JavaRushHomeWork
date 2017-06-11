package com.javarush.test.level27.lesson15.big01.ad;

import java.util.*;

/**
 * Created by Alex on 05.01.2017.
 */
public class StatisticAdvertisementManager
{
    private static StatisticAdvertisementManager singleInstance = new StatisticAdvertisementManager();

    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance()
    {
        return singleInstance;
    }

    private StatisticAdvertisementManager()
    {
        //storage = AdvertisementStorage.getInstance();
    }

    public List<Advertisement> getActiveAdvVideos()
    {
        if (storage != null)
        {
            List<Advertisement> activeAdvList = null;

            for (Object eachAdvVideo : storage.list())
            {
                Advertisement adv = (Advertisement) eachAdvVideo;
                if (adv.getHits() > 0)
                {
                    if (activeAdvList == null)
                        activeAdvList = new ArrayList<>();
                    activeAdvList.add(adv);
                }
            }
            return activeAdvList;
        }
        else
            return null;
    }

    public List<Advertisement> getInactiveAdvVideos()
    {
        if (storage != null)
        {
            List<Advertisement> inactiveAdvList = null;

            for (Object eachAdvVideo : storage.list())
            {
                Advertisement adv = (Advertisement) eachAdvVideo;
                if (adv.getHits() == 0)
                {
                    if (inactiveAdvList == null)
                        inactiveAdvList = new ArrayList<>();
                    inactiveAdvList.add(adv);
                }
            }
            return inactiveAdvList;
        }
        else
            return null;
    }
}
