package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

/**
 * Created by Alex on 03.01.2017.
 */
public interface EventDataRow
{
    public EventType getType();

    public Date getDate();
    public int getTime();
}
