package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (!(o instanceof Solution))
            return false;

        Solution n = (Solution) o;

        if (n.first == null && first == null && n.last == null && last == null)
            return true;
        else if (n.first == null && first == null)
            return n.last.equals(last);
        else if (n.last == null && last == null)
            return n.first.equals(first);
        else
            return n.first.equals(first) && n.last.equals(last);

        //return n.first.equals(first) && n.last.equals(last);
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
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
