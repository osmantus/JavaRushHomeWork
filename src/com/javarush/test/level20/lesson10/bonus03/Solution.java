package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        detectAllWords(crossword, "home", "same");
        //System.out.println(words);
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words)
    {
        if (words.length == 0)
            return null;

        if (crossword.length == 0)
        {
            return null;
        }
        if (crossword[0].length == 0)
        {
            return null;
        }

        LinkedList<ArrayList<Integer>> wordSymbolsByWord = new LinkedList<>();
        ArrayList<Integer> tempArray = null;

        for (int i = 0; i < words.length; i++)
        {
            char[] charArray = words[i].toCharArray();
            tempArray = new ArrayList<>();
            for (int j = 0; j < charArray.length; j++)
            {
                tempArray.add(Integer.valueOf(charArray[j]));
            }
            wordSymbolsByWord.add(tempArray);
        }

        List<Word> listOfWords = null;
        List<Word> listOfRawWords = new LinkedList<>();
        String tempWord = null;
        Word wordObj = null;
        int charCounter = 0;
        String curWord = null;

        for (int k = 0; k < wordSymbolsByWord.size(); k++)
        {
            curWord = words[k];
            tempArray = wordSymbolsByWord.get(k);

            for (int i = 0; i < crossword.length; i++)
            {
                tempWord = null;

                //считывание строки слева направо
                charCounter = 0;
                for (int j = 0; j < crossword[0].length; j++)
                {
                    if (tempArray.contains(crossword[i][j]))
                    {
                        if (charCounter == 0)
                        {
                            if (j + tempArray.size() <= crossword[0].length)
                            {
                                charCounter = charCounter + 1;
                                tempWord = String.valueOf((char) crossword[i][j]);
                                if (charCounter == tempArray.size())
                                {
                                    if (tempWord.equals(curWord))
                                    {
                                        wordObj = new Word(tempWord);
                                        wordObj.setStartPoint(j - charCounter+1, i);
                                        wordObj.setEndPoint(j, i);
                                        if (!listOfRawWords.contains(wordObj))
                                            listOfRawWords.add(wordObj);
                                    }
                                    charCounter = 0;
                                }
                            }
                            else
                            {
                                //дальше бессмысленно продолжать читать строку
                                break;
                            }
                        }
                        else
                        {
                            charCounter = charCounter + 1;
                            tempWord = tempWord.concat(String.valueOf((char) crossword[i][j]));
                            if (charCounter == tempArray.size())
                            {
                                if (tempWord.equals(curWord))
                                {
                                    wordObj = new Word(tempWord);
                                    wordObj.setStartPoint(j - charCounter+1, i);
                                    wordObj.setEndPoint(j, i);
                                    if (!listOfRawWords.contains(wordObj))
                                        listOfRawWords.add(wordObj);
                                }
                                charCounter = 0;
                            }
                        }

                    }
                    else
                    {
                        if (charCounter == tempArray.size())
                        {
                            if (tempWord.equals(curWord))
                            {
                                wordObj = new Word(tempWord);
                                wordObj.setStartPoint((j - 1) - charCounter+1, i);
                                wordObj.setEndPoint(j - 1, i);
                                if (!listOfRawWords.contains(wordObj))
                                    listOfRawWords.add(wordObj);
                            }
                        }
                        charCounter = 0;
                    }
                }

                tempWord = null;

                //считывание строки справа налево
                charCounter = 0;
                for (int j = crossword[0].length-1; j >= 0; j--)
                {
                    if (tempArray.contains(crossword[i][j]))
                    {
                        if (charCounter == 0)
                        {
                            if ((j+1) - tempArray.size() >= 0)
                            {
                                charCounter = charCounter + 1;
                                tempWord = String.valueOf((char) crossword[i][j]);
                                if (charCounter == tempArray.size())
                                {
                                    if (tempWord.equals(curWord))
                                    {
                                        wordObj = new Word(tempWord);
                                        wordObj.setStartPoint(j + charCounter-1, i);
                                        wordObj.setEndPoint(j, i);
                                        if (!listOfRawWords.contains(wordObj))
                                            listOfRawWords.add(wordObj);
                                    }
                                    charCounter = 0;
                                }
                            }
                            else
                            {
                                //дальше бессмысленно продолжать читать строку
                                break;
                            }
                        }
                        else
                        {
                            charCounter = charCounter + 1;
                            tempWord = tempWord.concat(String.valueOf((char) crossword[i][j]));
                            if (charCounter == tempArray.size())
                            {
                                if (tempWord.equals(curWord))
                                {
                                    wordObj = new Word(tempWord);
                                    wordObj.setStartPoint(j + charCounter-1, i);
                                    wordObj.setEndPoint(j, i);
                                    if (!listOfRawWords.contains(wordObj))
                                        listOfRawWords.add(wordObj);
                                }
                                charCounter = 0;
                            }
                        }
                    }
                    else
                    {
                        if (charCounter == tempArray.size())
                        {
                            if (tempWord.equals(curWord))
                            {
                                wordObj = new Word(tempWord);
                                wordObj.setStartPoint((j + 1) + charCounter-1, i);
                                wordObj.setEndPoint(j + 1, i);
                                if (!listOfRawWords.contains(wordObj))
                                    listOfRawWords.add(wordObj);
                            }
                        }
                        charCounter = 0;
                    }
                }

            }

            tempWord = null;

            //меняем порядок чтения 2-мерного массива (теперь вначале по столбцам (внутренний цикл), а потом по строкам (внешний цикл))
            for (int j = 0; j < crossword[0].length; j++)
            {
                //считывание столбца сверху вниз
                charCounter = 0;
                for (int i = 0; i < crossword.length; i++)
                {
                    if (tempArray.contains(crossword[i][j]))
                    {
                        if (charCounter == 0)
                        {
                            if (i + tempArray.size() <= crossword.length)
                            {
                                charCounter = charCounter + 1;
                                tempWord = String.valueOf((char) crossword[i][j]);
                                if (charCounter == tempArray.size())
                                {
                                    if (tempWord.equals(curWord))
                                    {
                                        wordObj = new Word(tempWord);
                                        wordObj.setStartPoint(j, i - charCounter+1);
                                        wordObj.setEndPoint(j, i);
                                        if (!listOfRawWords.contains(wordObj))
                                            listOfRawWords.add(wordObj);
                                    }
                                    charCounter = 0;
                                }
                            }
                            else
                            {
                                //дальше бессмысленно продолжать читать строку
                                break;
                            }
                        }
                        else
                        {
                            charCounter = charCounter + 1;
                            tempWord = tempWord.concat(String.valueOf((char) crossword[i][j]));
                            if (charCounter == tempArray.size())
                            {
                                if (tempWord.equals(curWord))
                                {
                                    wordObj = new Word(tempWord);
                                    wordObj.setStartPoint(j, i - charCounter+1);
                                    wordObj.setEndPoint(j, i);
                                    if (!listOfRawWords.contains(wordObj))
                                        listOfRawWords.add(wordObj);
                                }
                                charCounter = 0;
                            }
                        }
                    }
                    else
                    {
                        if (charCounter == tempArray.size())
                        {
                            if (tempWord.equals(curWord))
                            {
                                wordObj = new Word(tempWord);
                                wordObj.setStartPoint(j, (i - 1) - charCounter+1);
                                wordObj.setEndPoint(j, i - 1);
                                if (!listOfRawWords.contains(wordObj))
                                    listOfRawWords.add(wordObj);
                            }
                        }
                        charCounter = 0;
                    }
                }

                tempWord = null;

                //считывание столбца снизу вверх
                charCounter = 0;
                for (int i = crossword.length-1; i >= 0; i--)
                {
                    if (tempArray.contains(crossword[i][j]))
                    {
                        if (charCounter == 0)
                        {
                            if ((i+1) - tempArray.size() >= 0)
                            {
                                charCounter = charCounter + 1;
                                tempWord = String.valueOf((char) crossword[i][j]);
                                if (charCounter == tempArray.size())
                                {
                                    if (tempWord.equals(curWord))
                                    {
                                        wordObj = new Word(tempWord);
                                        wordObj.setStartPoint(j, i + charCounter-1);
                                        wordObj.setEndPoint(j, i);
                                        if (!listOfRawWords.contains(wordObj))
                                            listOfRawWords.add(wordObj);
                                    }
                                    charCounter = 0;
                                }
                            }
                            else
                            {
                                //дальше бессмысленно продолжать читать строку
                                break;
                            }
                        }
                        else
                        {
                            charCounter = charCounter + 1;
                            tempWord = tempWord.concat(String.valueOf((char) crossword[i][j]));
                            if (charCounter == tempArray.size())
                            {
                                if (tempWord.equals(curWord))
                                {
                                    wordObj = new Word(tempWord);
                                    wordObj.setStartPoint(j, i + charCounter-1);
                                    wordObj.setEndPoint(j, i);
                                    if (!listOfRawWords.contains(wordObj))
                                        listOfRawWords.add(wordObj);
                                }
                                charCounter = 0;
                            }
                        }
                    }
                    else
                    {
                        if (charCounter == tempArray.size())
                        {
                            if (tempWord.equals(curWord))
                            {
                                wordObj = new Word(tempWord);
                                wordObj.setStartPoint(j, (i + 1) + charCounter-1);
                                wordObj.setEndPoint(j, i + 1);
                                if (!listOfRawWords.contains(wordObj))
                                    listOfRawWords.add(wordObj);
                            }
                        }
                        charCounter = 0;
                    }
                }
            }

            tempWord = null;

            //теперь читаем по диагоналям

            //по диагоналям слева-направо, сверху-вниз
            for (int i = 0; i < crossword.length; i++)
            {
                for (int j = 0; j < crossword[0].length; j++)
                {
                    charCounter = 0;
                    for (int counterX = i, counterY = j; counterX < crossword.length && counterY < crossword[0].length; counterX++, counterY++)
                    {
                        if (tempArray.contains(crossword[counterX][counterY]))
                        {
                            if (charCounter == 0)
                            {
                                if (counterX + tempArray.size() <= crossword.length && counterY + tempArray.size() <= crossword[0].length)
                                {
                                    charCounter = charCounter + 1;
                                    tempWord = String.valueOf((char) crossword[counterX][counterY]);
                                    if (charCounter == tempArray.size())
                                    {
                                        if (tempWord.equals(curWord))
                                        {
                                            wordObj = new Word(tempWord);
                                            wordObj.setStartPoint( counterY - charCounter+1, counterX - charCounter+1 );
                                            wordObj.setEndPoint( counterY, counterX );
                                            if (!listOfRawWords.contains(wordObj))
                                                listOfRawWords.add(wordObj);
                                        }
                                        charCounter = 0;
                                    }
                                }
                                else
                                {
                                    //дальше бессмысленно продолжать читать строку
                                    break;
                                }
                            }
                            else
                            {
                                charCounter = charCounter + 1;
                                tempWord = tempWord.concat(String.valueOf((char) crossword[counterX][counterY]));
                                if (charCounter == tempArray.size())
                                {
                                    if (tempWord.equals(curWord))
                                    {
                                        wordObj = new Word(tempWord);
                                        wordObj.setStartPoint( counterY - charCounter+1, counterX - charCounter+1 );
                                        wordObj.setEndPoint( counterY, counterX );
                                        if (!listOfRawWords.contains(wordObj))
                                            listOfRawWords.add(wordObj);
                                    }
                                    charCounter = 0;
                                }
                            }
                        }
                        else
                        {
                            if (charCounter == tempArray.size())
                            {
                                if (tempWord.equals(curWord))
                                {
                                    wordObj = new Word(tempWord);
                                    wordObj.setStartPoint( (counterY - 1) - charCounter+1, (counterX - 1) - charCounter+1 );
                                    wordObj.setEndPoint( counterY - 1, counterX - 1 );
                                    if (!listOfRawWords.contains(wordObj))
                                        listOfRawWords.add(wordObj);
                                }
                            }
                            charCounter = 0;
                        }
                    }
                }
            }

            tempWord = null;

            //по диагоналям справа-налево, сверху-вниз
            for (int i = 0; i < crossword.length; i++)
            {
                for (int j = crossword[0].length-1; j >= 0; j--)
                {
                    charCounter = 0;
                    for (int counterX = i, counterY = j; counterX < crossword.length && counterY >= 0; counterX++, counterY--)
                    {
                        if (tempArray.contains(crossword[counterX][counterY]))
                        {
                            if (charCounter == 0)
                            {
                                if (counterX + tempArray.size() <= crossword.length && (counterY+1) - tempArray.size() >= 0)
                                {
                                    charCounter = charCounter + 1;
                                    tempWord = String.valueOf((char) crossword[counterX][counterY]);
                                    if (charCounter == tempArray.size())
                                    {
                                        if (tempWord.equals(curWord))
                                        {
                                            wordObj = new Word(tempWord);
                                            wordObj.setStartPoint( counterY + charCounter-1, counterX - charCounter+1 );
                                            wordObj.setEndPoint( counterY, counterX );
                                            if (!listOfRawWords.contains(wordObj))
                                                listOfRawWords.add(wordObj);
                                        }
                                        charCounter = 0;
                                    }
                                }
                                else
                                {
                                    //дальше бессмысленно продолжать читать строку
                                    break;
                                }
                            }
                            else
                            {
                                charCounter = charCounter + 1;
                                tempWord = tempWord.concat(String.valueOf((char) crossword[counterX][counterY]));
                                if (charCounter == tempArray.size())
                                {
                                    if (tempWord.equals(curWord))
                                    {
                                        wordObj = new Word(tempWord);
                                        wordObj.setStartPoint( counterY + charCounter-1, counterX - charCounter+1 );
                                        wordObj.setEndPoint( counterY, counterX );
                                        if (!listOfRawWords.contains(wordObj))
                                            listOfRawWords.add(wordObj);
                                    }
                                    charCounter = 0;
                                }
                            }
                        }
                        else
                        {
                            if (charCounter == tempArray.size())
                            {
                                if (tempWord.equals(curWord))
                                {
                                    wordObj = new Word(tempWord);
                                    wordObj.setStartPoint( (counterY + 1) + charCounter-1, (counterX - 1) - charCounter+1 );
                                    wordObj.setEndPoint( counterY + 1, counterX - 1 );
                                    if (!listOfRawWords.contains(wordObj))
                                        listOfRawWords.add(wordObj);
                                }
                            }
                            charCounter = 0;
                        }
                    }
                }
            }

            tempWord = null;

            //по диагоналям слева-направо, снизу-вверх
            for (int i = crossword.length-1; i >= 0; i--)
            {
                for (int j = 0; j < crossword[0].length; j++)
                {
                    charCounter = 0;
                    for (int counterX = i, counterY = j; counterX >= 0 && counterY < crossword[0].length; counterX--, counterY++)
                    {
                        if (tempArray.contains(crossword[counterX][counterY]))
                        {
                            if (charCounter == 0)
                            {
                                if ((counterX+1) - tempArray.size() >= 0 && counterY + tempArray.size() <= crossword[0].length)
                                {
                                    charCounter = charCounter + 1;
                                    tempWord = String.valueOf((char) crossword[counterX][counterY]);
                                    if (charCounter == tempArray.size())
                                    {
                                        if (tempWord.equals(curWord))
                                        {
                                            wordObj = new Word(tempWord);
                                            wordObj.setStartPoint( counterY - charCounter+1, counterX + charCounter-1 );
                                            wordObj.setEndPoint( counterY, counterX );
                                            if (!listOfRawWords.contains(wordObj))
                                                listOfRawWords.add(wordObj);
                                        }
                                        charCounter = 0;
                                    }
                                }
                                else
                                {
                                    //дальше бессмысленно продолжать читать строку
                                    break;
                                }
                            }
                            else
                            {
                                charCounter = charCounter + 1;
                                tempWord = tempWord.concat(String.valueOf((char) crossword[counterX][counterY]));
                                if (charCounter == tempArray.size())
                                {
                                    if (tempWord.equals(curWord))
                                    {
                                        wordObj = new Word(tempWord);
                                        wordObj.setStartPoint( counterY - charCounter+1, counterX + charCounter-1 );
                                        wordObj.setEndPoint( counterY, counterX );
                                        if (!listOfRawWords.contains(wordObj))
                                            listOfRawWords.add(wordObj);
                                    }
                                    charCounter = 0;
                                }
                            }
                        }
                        else
                        {
                            if (charCounter == tempArray.size())
                            {
                                if (tempWord.equals(curWord))
                                {
                                    wordObj = new Word(tempWord);
                                    wordObj.setStartPoint( (counterY - 1) - charCounter+1, (counterX + 1) + charCounter-1 );
                                    wordObj.setEndPoint( counterY - 1, counterX + 1 );
                                    if (!listOfRawWords.contains(wordObj))
                                        listOfRawWords.add(wordObj);
                                }
                            }
                            charCounter = 0;
                        }
                    }
                }
            }

            tempWord = null;

            //по диагоналям справа-налево, снизу-вверх
            for (int i = crossword.length-1; i >= 0; i--)
            {
                for (int j = crossword[0].length-1; j >= 0; j--)
                {
                    charCounter = 0;
                    for (int counterX = i, counterY = j; counterX >= 0 && counterY >= 0; counterX--, counterY--)
                    {
                        if (tempArray.contains(crossword[counterX][counterY]))
                        {
                            if (charCounter == 0)
                            {
                                if ((counterX+1) - tempArray.size() >= 0 && (counterY+1) - tempArray.size() >= 0)
                                {
                                    charCounter = charCounter + 1;
                                    tempWord = String.valueOf((char) crossword[counterX][counterY]);
                                    if (charCounter == tempArray.size())
                                    {
                                        if (tempWord.equals(curWord))
                                        {
                                            wordObj = new Word(tempWord);
                                            wordObj.setStartPoint( counterY + charCounter-1, counterX + charCounter-1 );
                                            wordObj.setEndPoint( counterY, counterX );
                                            if (!listOfRawWords.contains(wordObj))
                                                listOfRawWords.add(wordObj);
                                        }
                                        charCounter = 0;
                                    }
                                }
                                else
                                {
                                    //дальше бессмысленно продолжать читать строку
                                    break;
                                }
                            }
                            else
                            {
                                charCounter = charCounter + 1;
                                tempWord = tempWord.concat(String.valueOf((char) crossword[counterX][counterY]));
                                if (charCounter == tempArray.size())
                                {
                                    if (tempWord.equals(curWord))
                                    {
                                        wordObj = new Word(tempWord);
                                        wordObj.setStartPoint( counterY + charCounter-1, counterX + charCounter-1 );
                                        wordObj.setEndPoint( counterY, counterX );
                                        if (!listOfRawWords.contains(wordObj))
                                            listOfRawWords.add(wordObj);
                                    }
                                    charCounter = 0;
                                }
                            }
                        }
                        else
                        {
                            if (charCounter == tempArray.size())
                            {
                                if (tempWord.equals(curWord))
                                {
                                    wordObj = new Word(tempWord);
                                    wordObj.setStartPoint( (counterY + 1) + charCounter-1, (counterX + 1) + charCounter-1 );
                                    wordObj.setEndPoint( counterY + 1, counterX + 1 );
                                    if (!listOfRawWords.contains(wordObj))
                                        listOfRawWords.add(wordObj);
                                }
                            }
                            charCounter = 0;
                        }
                    }
                }
            }

        }

        for (Word obj: listOfRawWords)
        {
            System.out.println(obj);
        }

        return listOfRawWords;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other)
                return true;
            if (!(other instanceof Word))
                return false;
            Word otherA = (Word) other;

            return (text.equals(otherA.text));
        }

        @Override
        public int hashCode() {
            int hash = 1;
            hash = hash * 31 + text.hashCode();
            return hash;
        }
    }
}
