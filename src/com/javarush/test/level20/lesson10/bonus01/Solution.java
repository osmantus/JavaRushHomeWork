package com.javarush.test.level20.lesson10.bonus01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution
{
    public static int[] getNumbers(int N) throws InterruptedException
    {
        int[] result = null;

        ArrayList<Integer> globList = new ArrayList<>();

        int M;
        String numAsString = null;

        long sum;

        char[] digitCharsArray = null;
        char digitChar = 0;
        int digit = 0;

        long[][] powResultsByDigits = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024},
                {3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049},
                {4, 16, 64, 256, 1024, 4096, 16384, 65536, 262144, 1048576},
                {5, 25, 125, 625, 3125, 15625, 78125, 390625, 1953125, 9765625},
                {6, 36, 216, 1296, 7776, 46656, 279936, 1679616, 10077696, 60466176},
                {7, 49, 343, 2401, 16807, 117649, 823543, 5764801, 40353607, 282475249},
                {8, 64, 512, 4096, 32768, 262144, 2097152, 16777216, 134217728, 1073741824},
                {9, 81, 729, 6561, 59049, 531441, 4782969, 43046721, 387420489, 3486784401L}
        };

        for (int j = 1; j <= N; j++)
        {
            M = Long.toString(j).length();
            numAsString = String.valueOf(j);
            digitCharsArray = numAsString.toCharArray();

            sum = 0;

            for (int i = 0; i < M; i++)
            {
                digitChar = digitCharsArray[i];
                digit = (int)digitChar - 48;

                sum = sum + powResultsByDigits[digit][M-1];
            }

            if (sum == (long)j)
            {
                globList.add(j);
            }
        }

        result = new int[globList.size()];
        for (int i = 0; i < globList.size(); i++)
        {
            result[i] = globList.get(i);
        }

        return result;
    }

    public static void main(String[] args) throws Exception
    {
        int S = 1000000;
        int[] foundNumbers;

        if (S > 0)
        {
            foundNumbers = getNumbers(S);
        }

    }

}
