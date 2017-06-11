package com.javarush.test.level25.lesson07.task01;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;

/* Работать в поте лица!
Реализуйте логику метода interrupt, который должен прерывать трэд предварительно закрыв используемые ресурсы
Используйте метод super-класса в блоке finally
*/
public class Solution extends Thread {
    private static final int BUFFER_SIZE = 2000;    //2000 bytes
    private final Socket socket;
    private final InputStream in;

    public Solution(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();

        /*FileInputStream inputStream = new FileInputStream("D:\\Work\\Java\\Projects\\L25L7T1\\test.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));*/

        //this.in = inputStream;
    }

    public void interrupt() {
        //implement logic here
        try
        {
            /*if (in.available() > 0)
            {*/
                in.close();
                socket.close();
                throw new IOException();
            //}
        }
        catch (IOException e)
        {}
        finally
        {
            super.interrupt();
        }
    }

    public void run() {
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            while (true) {
                int count = in.read(buf);
                if (count < 0) {
                    break;
                } else {
                    if (count > 0) {
                        //process buffer here
                    }
                }
            }
        } catch (IOException ignored) {}
    }

    /*public static void main(String[] args) throws IOException, InterruptedException
    {
        Solution sol = new Solution(new Socket());
        sol.start();
        sol.sleep(10);
        sol.interrupt();
    }*/
}
