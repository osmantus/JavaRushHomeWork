package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Alex on 08.12.2016.
 */
class ExitCommand implements Command
{
    private Command command;
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "exit_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        String exitStatus = "";
        //ConsoleHelper.writeMessage("Будет выполнен выходит из меню. Продолжить (да - y, нет - n)?");
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));

        /*exitStatus = ConsoleHelper.readString();

        if (exitStatus.equalsIgnoreCase("y"))
        {
            ConsoleHelper.writeMessage("До свидания!");
            throw new InterruptOperationException();
        }*/

        exitStatus = ConsoleHelper.readString();

        if (res.getString("yes").equalsIgnoreCase(exitStatus.trim()))
        {
            //ConsoleHelper.writeMessage("До свидания!");
            ConsoleHelper.writeMessage(res.getString("thank.message"));
            //} else if ("n".equalsIgnoreCase(exitStatus.trim()))
            throw new InterruptOperationException();
        }
        else
        {
            CommandExecutor.execute(ConsoleHelper.askOperation());
        }
    }
}
