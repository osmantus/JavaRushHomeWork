package com.javarush.test.level30.lesson02.home01;

import java.math.BigInteger;

/* Конвертер систем счислений
Реализуйте логику метода convertNumberToOtherNumerationSystem, который должен переводить число number.getDigit()
из одной системы счисления(numerationSystem) в другую (expectedNumerationSystem)
бросьте NumberFormatException, если переданное число некорректно, например, число "120" с системой счисления 2
Валидация для - number.getDigit() - целое не отрицательное
Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumerationSystemType._16, "100");
        Number result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._10);
        System.out.println(result);    //expected 110
    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {

        int numerationSystem = number.getNumerationSystem().getNumerationSystemIntValue();

        String numberAsString = number.getDigit().toUpperCase();

        if (numberAsString.startsWith("-"))
            throw new NumberFormatException();

        char[] charsArray = numberAsString.toCharArray();

        char upperCharCode = 48;
        if (numerationSystem <= 10)
            upperCharCode = (char) (upperCharCode + numerationSystem - 1);
        else
            upperCharCode = (char) (65 + (numerationSystem - 1 - 10));


        for (int i = 0; i < charsArray.length; i++)
        {
            if (charsArray[i] < 48)
                throw new NumberFormatException();
            else if (charsArray[i] > 57 && charsArray[i] < 65)
                throw new NumberFormatException();
            else if (charsArray[i] >= 48 && charsArray[i] > upperCharCode)
                throw new NumberFormatException();
        }

        //Integer intValueInNativeNumeration = Integer.parseInt(numberAsString, numerationSystem);
        BigInteger intValueInNativeNumeration = new BigInteger(numberAsString, numerationSystem);

        int numerationSystemConvertTo = expectedNumerationSystem.getNumerationSystemIntValue();

        //String resultStr = Integer.toString(intValueInNativeNumeration, numerationSystemConvertTo);
        String resultStr = intValueInNativeNumeration.toString(numerationSystemConvertTo);

        Number result = new Number(expectedNumerationSystem, resultStr);

        return result;
    }
}
