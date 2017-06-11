package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.NoAvailableVideoEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

/**
 * Created by Alex on 01.01.2017.
 */
public class AdvertisementManager
{
    public final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds;

    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
    }

    private List<List<Advertisement>> getVideosCombinations(List<List<Advertisement>> videosToTestSelected, int step)
    {
        /*ArrayList<List<Advertisement>> videosCombinations = new ArrayList<>();

        if (videosToTestSelected.isEmpty())
        {
            videosCombinations.add(new ArrayList<Advertisement>());
            return videosCombinations;
        }
        else
        {
            List<Advertisement> list = new ArrayList<>(videosToTestSelected);
            Advertisement firstVideo = (Advertisement) list.get(0);
            List<Advertisement> restOfVideos = new ArrayList<>(list.subList(1, list.size()));

            for (List<Advertisement> eachRestVideo : getVideosCombinations(restOfVideos))
            {
                List<Advertisement> newVideosList = new ArrayList<>();
                if (firstVideo.getHits() > 0)
                {
                    newVideosList.add(firstVideo);
                    if (!eachRestVideo.isEmpty())
                        newVideosList.addAll(eachRestVideo);

                    videosCombinations.add(newVideosList);
                    videosCombinations.add(eachRestVideo);
                }
                else
                {
                    videosCombinations.add(eachRestVideo);
                }
            }
        }

        return videosCombinations;*/

        if (step == 0) return videosToTestSelected;

        int currentStep = step - 1;
        StringBuilder currentCombination = new StringBuilder(Integer.toBinaryString(currentStep));
        currentCombination.reverse();

        List<Advertisement> currentAdsCombination = new ArrayList<>();
        int totalDuration = 0;
        for (int i = 0; i < currentCombination.length(); i++) {
            if (currentCombination.charAt(i) == '1') {
                Advertisement ad = storage.list().get(i);
                if (ad.getDuration() <= timeSeconds && ad.getHits() > 0) {
                    totalDuration += ad.getDuration();
                    currentAdsCombination.add(ad);
                }
            }
        }

        if (totalDuration > 0 && totalDuration <= this.timeSeconds)
            videosToTestSelected.add(currentAdsCombination);

        return getVideosCombinations(videosToTestSelected, currentStep);
    }

    private List<Advertisement> getMaxProfitVideos(List<List<Advertisement>> listOfVideosLists)
    {
        if (!listOfVideosLists.isEmpty())
        {
            int sumDuration;

            Iterator iterator = listOfVideosLists.iterator();
            while (iterator.hasNext())
            {
                List<Advertisement> list = (ArrayList<Advertisement>) iterator.next();
                sumDuration = 0;
                boolean removeSet = false;

                for (int i = 0; i < list.size(); i++)
                {
                    Advertisement adv = (Advertisement) list.get(i);
                    sumDuration = sumDuration + adv.getDuration();
                    if (adv.getHits() <= 0)
                        removeSet = true;
                }
                if (sumDuration > timeSeconds)
                    removeSet = true;
                if (removeSet)
                    iterator.remove();

            }

            if (!listOfVideosLists.isEmpty())
            {
                Collections.sort(listOfVideosLists, new Comparator<List<Advertisement>>()
                {
                    @Override
                    public int compare(List<Advertisement> o1, List<Advertisement> o2)
                    {
                        List<Advertisement> listOfVideos1 = o1;
                        List<Advertisement> listOfVideos2 = o2;

                        long listOfVideos1SumAmount = 0;
                        long listOfVideos2SumAmount = 0;

                        int sumDuration1 = 0;
                        int sumDuration2 = 0;

                        for (int i = 0; i < listOfVideos1.size(); i++)
                        {
                            Advertisement adv1 = listOfVideos1.get(i);
                            listOfVideos1SumAmount = listOfVideos1SumAmount + adv1.getAmountPerOneDisplaying();
                            sumDuration1 = sumDuration1 + adv1.getDuration();
                        }
                        for (int i = 0; i < listOfVideos2.size(); i++)
                        {
                            Advertisement adv2 = listOfVideos2.get(i);
                            listOfVideos2SumAmount = listOfVideos2SumAmount + adv2.getAmountPerOneDisplaying();
                            sumDuration2 = sumDuration2 + adv2.getDuration();
                        }

                        if (listOfVideos1SumAmount > listOfVideos2SumAmount)
                            return -1;
                        else if (listOfVideos1SumAmount == listOfVideos2SumAmount)
                        {
                            if (sumDuration1 > sumDuration2)
                                return -1;
                            else if (sumDuration1 == sumDuration2)
                                return listOfVideos1.size() - listOfVideos2.size();
                            else
                                return 1;
                        } else
                            return 1;
                    }
                });

                return listOfVideosLists.get(0);    //возвращаем 1-ый элемент сверху - как наиболее выгодный после сортировки
            }
            else
                return null;
        }
        else
            return null;
    }

    public void processVideos() throws NoVideoAvailableException
    {
        List<Advertisement> selectedVideos = null;
        //selectedVideos = getMaxProfitVideos(getVideosCombinations(storage.list()));

        selectedVideos = getMaxProfitVideos( getVideosCombinations(new ArrayList<List<Advertisement>>(), (int) Math.pow(2, storage.list().size())) );

        if (selectedVideos != null)
        {
            if (selectedVideos.size() <= 0 || selectedVideos.isEmpty())
            {
                NoAvailableVideoEventDataRow event = new NoAvailableVideoEventDataRow(timeSeconds);
                StatisticEventManager.getInstance().register(event);

                throw new NoVideoAvailableException();
            }
            else
            {
                try
                {
                    Collections.sort(selectedVideos, new Comparator<Advertisement>()
                    {
                        @Override
                        public int compare(Advertisement o1, Advertisement o2)
                        {
                            Advertisement adv1, adv2;
                            adv1 = o1;
                            adv2 = o2;

                            long amount1 = adv1.getAmountPerOneDisplaying();
                            long amount2 = adv2.getAmountPerOneDisplaying();

                            if (amount1 > amount2)
                            {
                                return -1;
                            } else if (amount1 == amount2)
                            {
                                long advOneSecondCost1 = (amount1 * 1000) / adv1.getDuration();
                                long advOneSecondCost2 = (amount2 * 1000) / adv2.getDuration();

                                if (advOneSecondCost1 < advOneSecondCost2)
                                    return -1;
                                else
                                    return 1;
                            } else
                            {
                                return 1;
                            }
                        }
                    });

                    long totalAmount = 0;
                    int totalDuration = 0;

                    for (int i = 0; i < selectedVideos.size(); i++)
                    {
                        totalAmount += selectedVideos.get(i).getAmountPerOneDisplaying();
                        totalDuration += selectedVideos.get(i).getDuration();
                    }

                    VideoSelectedEventDataRow event = new VideoSelectedEventDataRow(selectedVideos, totalAmount, totalDuration);
                    StatisticEventManager.getInstance().register(event);

                    Advertisement video = null;
                    Iterator<Advertisement> itetator = selectedVideos.iterator();
                    while (itetator.hasNext())
                    {
                        video = (Advertisement) itetator.next();
                        /*if (video.getClass().getSimpleName().equals("Advertisement"))
                        {*/
                            long amount = video.getAmountPerOneDisplaying();
                            long advOneSecondCost = (amount * 1000) / video.getDuration();
                            if (video.getDuration() <= timeSeconds)
                            {
                                //System.out.println(video.getName() + " is displaying... " + amount + ", " + advOneSecondCost);
                                ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", video.getName(), amount, advOneSecondCost));
                                video.revalidate();
                            }
                        //}
                    }
                }
                catch (Exception e)
                {
                    NoAvailableVideoEventDataRow event = new NoAvailableVideoEventDataRow(timeSeconds);
                    StatisticEventManager.getInstance().register(event);

                    throw new NoVideoAvailableException();
                }
            }
        }
        else
        {
            NoAvailableVideoEventDataRow event = new NoAvailableVideoEventDataRow(timeSeconds);
            StatisticEventManager.getInstance().register(event);

            throw new NoVideoAvailableException();
        }
    }
}
