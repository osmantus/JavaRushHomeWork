package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException
    {
        String result = null;
        try
        {
            int pos = string.indexOf(" ");
            int prevPos = 0;
            String subStr = null;

            if (pos > 0)
            {
                prevPos = pos+1;
                subStr = string.substring(pos);
                if (subStr.length() > 0)
                {
                    for (int i = 0; i < 4; i++)
                    {
                        pos = subStr.indexOf(" ", 1);
                        if (pos == -1)
                        {
                            throw new TooShortStringException();
                            //break;
                        }

                        if (result == null)
                            result = string.substring(prevPos, prevPos + pos);
                        else
                            result = result.concat(string.substring(prevPos, prevPos + pos));
                        prevPos = prevPos + pos;
                        subStr = string.substring(prevPos);
                    }
                } else
                    throw new TooShortStringException();
            } else
                throw new TooShortStringException();
        }
        catch (Exception e)
        {
            throw new TooShortStringException();
        }

        return result;
    }

    public static class TooShortStringException extends Throwable {
    }

    public static void main(String[] args)
    {
        try
        {
            String str = getPartOfString("JavaRush - лучший сервис обучения Java.");
        }
        catch (TooShortStringException e)
        {}
    }
}
