package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 08.12.2016.
 */
public class CommandExecutor
{
    static private Map<Operation, Command> map = new HashMap<>();

    static {
        map.put(Operation.LOGIN, new LoginCommand());
        map.put(Operation.INFO, new InfoCommand());
        map.put(Operation.DEPOSIT, new DepositCommand());
        map.put(Operation.WITHDRAW, new WithdrawCommand());
        map.put(Operation.EXIT, new ExitCommand());
    }

    private CommandExecutor()
    {

    }

    public static final void execute(Operation operation) throws InterruptOperationException
    {
        if (map != null)
        {
            if (map.containsKey(operation))
            {
                Command command = map.get(operation);
                command.execute();
            }
        }
    }
}
