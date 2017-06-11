package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Alex on 28.01.2017.
 */
public class BotClient extends Client
{
    private static int nextBotID = 0;

    public static void main(String[] args)
    {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread
    {
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
            if (message.contains(": "))
            {
                String senderName = message.split(":")[0];
                String msgText = message.split(":")[1].trim();

                if (!senderName.isEmpty() && !msgText.isEmpty())
                {
                    SimpleDateFormat format = null;

                    switch (msgText)
                    {
                        case "дата":
                            format = new SimpleDateFormat("d.MM.YYYY", Locale.ENGLISH);
                            break;

                        case "день":
                            format = new SimpleDateFormat("d", Locale.ENGLISH);
                            break;

                        case "месяц":
                            format = new SimpleDateFormat("MMMM", Locale.ENGLISH);
                            break;

                        case "год":
                            format = new SimpleDateFormat("YYYY", Locale.ENGLISH);
                            break;

                        case "время":
                            format = new SimpleDateFormat("H:mm:ss", Locale.ENGLISH);
                            break;

                        case "час":
                            format = new SimpleDateFormat("H", Locale.ENGLISH);
                            break;

                        case "минуты":
                            format = new SimpleDateFormat("m", Locale.ENGLISH);
                            break;

                        case "секунды":
                            format = new SimpleDateFormat("s", Locale.ENGLISH);
                            break;

                        default:
                            return;
                    }

                    Date curDate = Calendar.getInstance().getTime();
                    sendTextMessage(String.format("Информация для %s: %s", senderName, format.format(curDate)));
                }
            }
        }
    }

    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }

    protected boolean shouldSentTextFromConsole()
    {
        return false;
    }

    protected String getUserName()
    {
        String botNameBaseStr = "date_bot_";

        String additionalStr = "";
        if (nextBotID < 10)
            additionalStr = String.format("0%s", nextBotID);
        else
            additionalStr = String.format("%s", nextBotID);
        nextBotID++;
        if (nextBotID == 100)
            nextBotID = 0;
        String botName = botNameBaseStr.concat(additionalStr);
        return botName;
    }
}
