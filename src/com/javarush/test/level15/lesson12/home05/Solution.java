package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    Solution(boolean bool)
    {}
    Solution(float floatNumber)
    {}
    Solution(byte byteVar)
    {}

    private Solution()
    {}
    private Solution(long longNumber)
    {}
    private Solution(char charVar)
    {}

    public Solution(int intNumber)
    {}
    public Solution(short shortNumber)
    {}
    public Solution(double doubleNumber)
    {}

    protected Solution(String anyString)
    {}
    protected Solution(Integer anyString)
    {}
    protected Solution(Float anyString)
    {}
}

