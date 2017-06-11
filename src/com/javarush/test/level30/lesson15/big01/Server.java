package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alex on 22.01.2017.
 */
public class Server
{
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException
    {
        ConsoleHelper.writeMessage("Введите порт сервера: ");
        int serverPort = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(serverPort))
        {
            ConsoleHelper.writeMessage("Сервер запущен");

            while (true)
            {
                Socket freeSocket = serverSocket.accept();
                Handler handler = new Handler(freeSocket);

                handler.start();
            }
        }
        catch (Exception e)
        {
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }

    public static void sendBroadcastMessage(Message message)
    {
        try
        {
            for (Map.Entry<String, Connection> eachEntry : connectionMap.entrySet())
            {
                Connection connection = eachEntry.getValue();
                connection.send(message);
            }
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("Не смогли отправить сообщение");
        }
    }

    private static class Handler extends Thread
    {
        private Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message msg = new Message(MessageType.NAME_REQUEST);
                connection.send(msg);
                Message clientFromMsg = connection.receive();
                if (clientFromMsg.getType() == MessageType.USER_NAME)
                {
                    String userName = clientFromMsg.getData();
                    if (userName != null && !userName.equals(""))
                    {
                        if (!connectionMap.containsKey(userName))
                        {
                            connectionMap.put(userName, connection);
                            Message msgToClient = new Message(MessageType.NAME_ACCEPTED);
                            connection.send(msgToClient);
                            return userName;
                        }
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException
        {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet())
            {
                String iterUserName = entry.getKey();
                if (!iterUserName.equals(userName))
                {
                    Message msgToUser = new Message(MessageType.USER_ADDED, iterUserName);
                    connection.send(msgToUser);
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException
        {
            while (true)
            {
                Message msgFromClient = connection.receive();
                if (msgFromClient.getType() == MessageType.TEXT)
                {
                    String newSendBackText = userName + ": " + msgFromClient.getData();
                    Message newSendBackTextMsg = new Message(MessageType.TEXT, newSendBackText);
                    sendBroadcastMessage(newSendBackTextMsg);
                }
                else
                    ConsoleHelper.writeMessage(String.format("Ошибка при получении сообщения от пользователя %s!", userName));
            }
        }

        @Override
        public void run()
        {
            SocketAddress address = socket.getRemoteSocketAddress();
            ConsoleHelper.writeMessage(String.format("Установлено новое соединение с удалённым адресом %s", address));

            String newUserName = null;
            try (Connection conn = new Connection(socket))
            {
                newUserName = serverHandshake(conn);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, newUserName));
                sendListOfUsers(conn, newUserName);
                serverMainLoop(conn, newUserName);
            }
            catch (IOException | ClassNotFoundException e)
            {
                ConsoleHelper.writeMessage(String.format("Произошла ошибка при обмене данными c удалённым адресом %s", address));
            }
            finally
            {
                if (newUserName != null)
                {
                    connectionMap.remove(newUserName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newUserName));
                }
            }
            ConsoleHelper.writeMessage(String.format("Было закрыто соединение с удалённым адресом %s", address));
        }
    }
}
