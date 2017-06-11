package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Alex on 26.01.2017.
 */
public class Client
{
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args)
    {
        Client client = new Client();
        client.run();
    }

    public void run()
    {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);

        socketThread.start();
        try
        {
            synchronized (this)
            {
                this.wait();
            }
        }
        catch (InterruptedException e)
        {
            ConsoleHelper.writeMessage("Возникла ошибка во время ожидания соединения с сервером.");
            return;
        }

        if (clientConnected)
        {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
            while (clientConnected)
            {
                String str = ConsoleHelper.readString();
                if (str.equals("exit"))
                    break;

                if (shouldSentTextFromConsole())
                {
                    sendTextMessage(str);
                }
            }
        }
        else
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");

    }

    public class SocketThread extends Thread
    {
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName)
        {
            ConsoleHelper.writeMessage(String.format("Участник с %s присоединился к чату.", userName));
        }

        protected void informAboutDeletingNewUser(String userName)
        {
            ConsoleHelper.writeMessage(String.format("Участник с %s покинул чат.", userName));
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected)
        {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this)
            {
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException
        {
            while (true)
            {
                if (connection != null)
                {
                    Message msgFromServer = connection.receive();
                    switch (msgFromServer.getType())
                    {
                        case NAME_REQUEST:
                            String userName = getUserName();
                            Message replyToServer = new Message(MessageType.USER_NAME, userName);
                            connection.send(replyToServer);
                            break;

                        case NAME_ACCEPTED:
                            notifyConnectionStatusChanged(true);
                            return;

                        default:
                            throw new IOException("Unexpected MessageType");
                    }
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            while (true)
            {
                if (connection != null)
                {
                    Message msgFromServer = connection.receive();
                    switch (msgFromServer.getType())
                    {
                        case TEXT:
                            processIncomingMessage(msgFromServer.getData());
                            break;
                        case USER_ADDED:
                            informAboutAddingNewUser(msgFromServer.getData());
                            break;
                        case USER_REMOVED:
                            informAboutDeletingNewUser(msgFromServer.getData());
                            break;
                        default:
                            throw new IOException("Unexpected MessageType");
                    }
                }
            }
        }

        public void run()
        {
            String ipAddress = getServerAddress();
            int port = getServerPort();

            try
            {
                Socket socket = new Socket(ipAddress, port);
                connection = new Connection(socket);

                clientHandshake();
                clientMainLoop();
            }
            catch (IOException | ClassNotFoundException e)
            {
                notifyConnectionStatusChanged(false);
            }
        }
    }

    protected String getServerAddress()
    {
        ConsoleHelper.writeMessage("Введите адрес сервера: ");
        String ServerIP = ConsoleHelper.readString();
        return ServerIP;
    }

    protected int getServerPort()
    {
        ConsoleHelper.writeMessage("Введите порт сервера: ");
        int serverPort = ConsoleHelper.readInt();
        return serverPort;
    }

    protected String getUserName()
    {
        ConsoleHelper.writeMessage("Введите имя пользователя: ");
        String userName = ConsoleHelper.readString();
        return userName;
    }

    protected boolean shouldSentTextFromConsole()
    {
        return true;
    }

    protected SocketThread getSocketThread()
    {
        return new SocketThread();
    }

    protected void sendTextMessage(String text)
    {
        Message msg = new Message(MessageType.TEXT, text);
        try
        {
            connection.send(msg);
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("Ошибка отправки сообщения серверу.");
            clientConnected = false;
        }
    }
}
