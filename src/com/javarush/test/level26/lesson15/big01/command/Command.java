package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by Alex on 08.12.2016.
 */
interface Command
{
    void execute() throws InterruptOperationException;
}
