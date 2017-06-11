package com.javarush.test.level22.lesson13.task03;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {

    public static boolean checkTelNumber(String telNumber) {

        boolean checkAllCases = false;

        if (telNumber != null)
        {
            if (telNumber.length() >= 10)
            {
                if (telNumber.substring(0, 1).equals("+"))
                {
                    if (telNumber.contains("(") && telNumber.contains(")"))
                    {
                        if ((telNumber.length() == 15 && telNumber.matches("^\\+\\d{0,8}\\(\\d{3}\\)\\d{0,8}")) ||
                                (telNumber.length() == 17 && telNumber.matches("^\\+\\d{0,6}\\(\\d{3}\\)\\d{1,6}-{1}\\d{1,6}-{1}\\d{1,6}")) ||
                                (telNumber.length() == 15 && telNumber.matches("^\\+\\d{0,8}\\(\\d{3}\\)\\d{0,8}")) ||
                                (telNumber.length() == 16 && telNumber.matches("^\\+\\d{0,8}\\(\\d{3}\\)-{1}\\d{1,8}")))
                        {
                            checkAllCases = true;
                        }
                    } else
                    {
                        if (telNumber.matches("^\\+\\d{12}") ||
                                (telNumber.length() == 15 && telNumber.matches("^\\+\\d{1,2}-{1}\\d{1,10}-{1}\\d{1,10}")) ||
                                (telNumber.length() == 14 && telNumber.matches("^\\+\\d{1,2}-{1}\\d{1,11}")) ||
                                (telNumber.length() == 15 && telNumber.matches("^\\+\\d{5,10}-{1}\\d{1,10}-{1}\\d{1,10}")) ||
                                (telNumber.length() == 14 && telNumber.matches("^\\+\\d{5,11}-{1}\\d{1,11}")) ||
                                (telNumber.length() == 15 && telNumber.matches("^\\+-{1}\\d{1,11}-{1}\\d{1,11}")) ||
                                (telNumber.length() == 14 && telNumber.matches("^\\+-{1}\\d{12}")))
                        {
                            checkAllCases = true;
                        }
                    }
                } else if (telNumber.contains("(") && telNumber.contains(")"))
                {
                    if (telNumber.matches("^\\(\\d{3}\\)\\d{7}") ||
                            (telNumber.length() == 12 && telNumber.matches("\\d{0,7}\\(\\d{3}\\)\\d{1,7}")) ||
                            (telNumber.length() == 14 && telNumber.matches("\\d{0,4}\\(\\d{3}\\)\\d{1,4}-{1}\\d{1,4}-{1}\\d{1,4}")) ||
                            (telNumber.length() == 13 && telNumber.matches("\\d{0,5}\\(\\d{3}\\)\\d{1,5}-{1}\\d{1,5}")) ||
                            (telNumber.length() == 14 && telNumber.matches("^\\(\\d{3}\\)\\d{1,5}-{1}\\d{1,5}-{1}\\d{1,5}")) ||
                            (telNumber.length() == 13 && telNumber.matches("^\\(\\d{3}\\)\\d{1,6}-{1}\\d{1,6}")))

                        checkAllCases = true;
                } else
                {
                    if (telNumber.matches("\\d{10}") ||
                            (telNumber.length() == 12 && telNumber.matches("\\d{1,3}-{1}\\d{1,8}-{1}\\d{1,8}")) ||
                                    (telNumber.length() == 11 && telNumber.matches("\\d{1,3}-{1}\\d{1,9}")) ||
                            (telNumber.length() == 12 && telNumber.matches("\\d{5,8}-{1}\\d{1,8}-{1}\\d{1,8}")) ||
                            (telNumber.length() == 11 && telNumber.matches("\\d{5,9}-{1}\\d{1,9}")) ||
                            (!telNumber.substring(0, 2).equals("38") && ((telNumber.length() == 12 && telNumber.matches("\\d{4}-{1}\\d{1,8}-{1}\\d{1,8}")) ||
                            (telNumber.length() == 11 && telNumber.matches("\\d{4}-{1}\\d{1,9}")))))

                        checkAllCases = true;
                }
            }
        }

        return checkAllCases;
    }

    public static void main(String[] args)
    {
        checkTelNumber("+380501234567");
        checkTelNumber("+38(050)1234567");
        //checkTelNumber("+38(050)");

        checkTelNumber("+38050123-45-67");
        checkTelNumber("050123-4567");

        checkTelNumber("+8-050912345-67"); //
        checkTelNumber("(805)09-123-46");
        checkTelNumber("+38050(123)4512"); //
        checkTelNumber("38(050)12345"); //
        checkTelNumber("12345678-9-0");
        checkTelNumber("1-23456789-0");
        checkTelNumber("+12(123)3-4567-89");

        checkTelNumber("+38(050)-1234567");
        checkTelNumber("+(012)-12345678-9");
        checkTelNumber("-3805012345-67");
        checkTelNumber("+(012)-1-23456789");
        checkTelNumber("051202(345)-7");
        checkTelNumber("+38051202(345)-7");

        checkTelNumber("+38)050(1234567");
        checkTelNumber("+38(050)1-23-45-6-7");
        checkTelNumber("050ххх4567");
        checkTelNumber("050123456");
        checkTelNumber("(0)501234567");

        checkTelNumber("+38050)1234567");
        checkTelNumber("3805-012345");

        System.out.println(checkTelNumber("+38(050)12-34-567"));
        System.out.println(", need FALSE - " + checkTelNumber(""));
        System.out.println("null, need FALSE - " + checkTelNumber(null));
        System.out.println("+313450--531202, need FALSE - " + checkTelNumber("+313450--531202"));
        System.out.println("+38(05)1234567, need FALSE - " + checkTelNumber("+38(05)1234567"));
        System.out.println("(3)80501234567, need FALSE - " + checkTelNumber("(3)80501234567"));
        System.out.println("(380)501234567, need FALSE - " + checkTelNumber("(380)501234567"));
        System.out.println("(380)501-234567, need FALSE - " + checkTelNumber("(380)501-234567"));
        System.out.println("(38-0)501234567, need FALSE - " + checkTelNumber("(38-0)501234567"));
        System.out.println("380-(501)234567, need FALSE - " + checkTelNumber("380-(501)234567"));
        System.out.println("380(50-1)234567, need FALSE - " + checkTelNumber("380(50-1)234567"));
        System.out.println("380(501)(23)4567, need FALSE - " + checkTelNumber("380(501)(23)4567"));
        System.out.println("+38050123(456)76, need FALSE - " + checkTelNumber("+38050123(456)76"));///
        System.out.println("+38050123(456)768, need FALSE - " + checkTelNumber("+38050123(456)768"));///
        System.out.println("+38050123(456)7685, need FALSE - " + checkTelNumber("+38050123(456)7685"));///
        System.out.println("+380501234(567), need FALSE - " + checkTelNumber("+380501234(567)"));
        System.out.println("3-805-0123-45, need FALSE - " + checkTelNumber("3-805-0123-45"));
        System.out.println("-3805-012345, need FALSE - " + checkTelNumber("-3805-012345"));
        System.out.println("3805-012345-, need FALSE - " + checkTelNumber("3805-012345-"));
        System.out.println("+38(05)01234567, need FALSE - " + checkTelNumber("+38(05)01234567"));
        System.out.println("+38(0501)234567, need FALSE - " + checkTelNumber("+38(0501)234567"));
        System.out.println("(050)12345678, need FALSE - " + checkTelNumber("(050)12345678"));
        System.out.println("+38)050(1234567, need FALSE - " + checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)1-23-45-6-7, need FALSE - " + checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println("050ххх4567, need FALSE - " + checkTelNumber("050ххх4567"));
        System.out.println("050123456, need FALSE - " + checkTelNumber("050123456"));
        System.out.println("+38-(050)1234567, need FALSE - " + checkTelNumber("+38-(050)1234567"));
        System.out.println("+38((050)1234567, need FALSE - " + checkTelNumber("+38((050)1234567"));
        System.out.println("+5(0--5)1234567, need FALSE - " + checkTelNumber("+5(0--5)1234567"));
        System.out.println("7-4-4123689-5, need FALSE - " + checkTelNumber("7-4-4123689-5"));
        System.out.println("+38051202(345)7, need TRUE - " + checkTelNumber("+38051202(345)7"));
        System.out.println("+38051202(345)-7, need TRUE - " + checkTelNumber("+38051202(345)-7"));
        System.out.println("+-313450531202, need TRUE - " + checkTelNumber("+-313450531202"));
        System.out.println("380-50123-45, need TRUE - " + checkTelNumber("380-50123-45"));
        System.out.println("+38050123(456)7, need TRUE - " + checkTelNumber("+38050123(456)7"));
        System.out.println("+38050123-45-67, need TRUE - " + checkTelNumber("+38050123-45-67"));
        System.out.println("050123-4567, need TRUE - " + checkTelNumber("050123-4567"));
        System.out.println("(050)123-4567, need TRUE - " + checkTelNumber("(050)123-4567"));
        System.out.println("(050)1234567, need TRUE - " + checkTelNumber("(050)1234567"));
        System.out.println("+380501234567, need TRUE - " + checkTelNumber("+380501234567"));
        System.out.println("+38(050)1234567, need TRUE - " + checkTelNumber("+38(050)1234567"));
        System.out.println("1-23456789-0, need TRUE - " + checkTelNumber("1-23456789-0"));
    }
}
