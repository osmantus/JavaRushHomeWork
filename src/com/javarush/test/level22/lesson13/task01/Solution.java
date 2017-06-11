package com.javarush.test.level22.lesson13.task01;

import java.util.LinkedList;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {

        String[] result = null;
        if (query != null && delimiter != null)
        {
            StringTokenizer st = new StringTokenizer(query, delimiter);
            int tokenCount = 0;

            if (st != null)
            {
                result = new String[st.countTokens()];
                while (st.hasMoreTokens())
                {
                    String token = st.nextToken();
                    result[tokenCount] = token;
                    tokenCount++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        String[] tokens = getTokens("level22.lesson13.task01", ".");
    }
}
