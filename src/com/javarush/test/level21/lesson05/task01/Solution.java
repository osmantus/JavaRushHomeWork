package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object n) {
        if (n == null)
            return false;
        if (this.getClass() != n.getClass())
            return false;

        Solution obj = (Solution) n;

        if (obj.first == null && first == null && obj.last == null && last == null)
            return true;
        else if (obj.first == null && first == null)
            return obj.last.equals(last);
        else if (obj.last == null && last == null)
            return obj.first.equals(first);
        else
            return obj.first.equals(first) && obj.last.equals(last);
    }

    @Override
    public int hashCode()
    {
        int result = 0;

        if (first != null)
        {
            for (int i = 0, j = first.length() - 1; i < first.length(); i++, j--)
                result = result + (int) first.charAt(i) * (int) Math.pow(31, j);
        }

        if (last != null)
        {
            for (int i = 0, j = last.length() - 1; i < last.length(); i++, j--)
                result = result + (int) last.charAt(i) * (int) Math.pow(31, j);
        }

        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        //s.add(new Solution("Donald", "Duck"));
        s.add(new Solution(null, "Duck"));
        //System.out.println(s.contains(new Solution("Donald", "Duck")));
        System.out.println(s.contains(new Solution(null, "Duck")));
    }
}
