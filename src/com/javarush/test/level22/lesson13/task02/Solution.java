package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {

        if (args != null)
        {
            if (args.length == 2)
            {
                //FileOutputStream outOriginal = new FileOutputStream(args[0]);
                FileInputStream in = new FileInputStream(args[0]);
                FileOutputStream out = new FileOutputStream(args[1]);

                String decodedStr = null;
                /*if (outOriginal != null)
                {
                    byte[] orig = win1251TestString.getBytes(Charset.forName("Windows-1251"));
                    decodedStr = new String(orig);
                    outOriginal.write(decodedStr.getBytes());
                    outOriginal.close();
                }*/

                if (in.available() > 0 && out != null)
                {
                    Charset win1251Charset = Charset.forName("Windows-1251");
                    byte[] curCharsetByteArray = null;

                    String line = null;
                    File file = new File(args[0]);
                    int fileLen = 0;
                    byte[] originalStrBytes = new byte[(int) file.length()];
                    fileLen = in.read(originalStrBytes);

                    if (fileLen > 0)
                    {
                        String decodedLine = new String(originalStrBytes, "UTF-8");
                        out.write(decodedLine.getBytes(win1251Charset));
                        out.flush();
                    }
                    in.close();
                }
                out.close();
            }
        }
    }
}
